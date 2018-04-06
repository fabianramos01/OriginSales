package model;

import java.util.ArrayList;

import controller.ConstantList;

public class ManagerUser {

	private int id;
	private int credits;
	private MyStack<Game> userList;
	private MyStack<Game> refundList;
	private NodeList<Game> games;
	private MyQueue<Game> request;

	public ManagerUser() {
		id = (int) (Math.random() * 1000);
		userList = new MyStack<Game>();
		games = new NodeList<Game>(new Comparator());
		refundList = new MyStack<Game>();
		request = new MyQueue<Game>();
		credits = ConstantList.INITIAL_CREDITS;
	}

	public void addGame(Game game) {
		Node<Game> actual = games.getHead();
		while (actual != null) {
			if (actual.getInfo().getName().equalsIgnoreCase(game.getName())) {
				if (actual.getInfo().getVersion() > game.getVersion()) {
					games.addBefore(games.createNode(game), actual);
					break;
				} else if (actual.getNext() != null) {
					if (!actual.getNext().getInfo().getName().equalsIgnoreCase(game.getName())) {
						games.addAfter(games.createNode(game), actual);
						break;
					}
				}
			}
			actual = actual.getNext();
		}
		if (!games.exist(games.createNode(game))) {
			games.addLast(games.createNode(game));
		}
	}

	public void refund() {
		if (userList.peek() != null) {
			Game game = userList.pop().getInfo();
			credits += game.getValue();
			addGame(game);
			refundList.push(refundList.createNode(game));
		}
	}

	public void cancelRefund() {
		if (refundList.peek() != null) {
			buyGame(refundList.pop().getInfo());
		}
	}

	public void buyGame(Game game) {
		Node<Game> removeGame = search(game);
		if (removeGame.getInfo().getValue() <= credits) {
			credits -= removeGame.getInfo().getValue();
			userList.push(userList.createNode(removeGame.getInfo()));
		} else {
			request.enqueue(request.createNode(removeGame.getInfo()));
		}
		games.remove(removeGame);
	}

	private Node<Game> search(Game game) {
		Comparator comparator = new Comparator();
		Node<Game> actual = games.getHead();
		while (actual != null) {
			if (comparator.compare(actual.getInfo(), game) == 0) {
				return actual;
			}
			actual = actual.getNext();
		}
		return null;
	}

	public int getCredits() {
		return credits;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Game> getUserList() {
		return userList.getList();
	}

	public ArrayList<Game> getGameList() {
		return games.getInfoList();
	}

	public Node<Game> getRequest() {
		if (request.size() != 0) {
			return request.dequeue();
		}
		return null;
	}
}