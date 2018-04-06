package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.Timer;

import view.PrincipalFrame;
import model.Game;
import model.ManagerUser;
import model.Node;

public class Controller extends KeyAdapter implements ActionListener {

	private ManagerUser managerUser;
	private PrincipalFrame principalFrame;
	private int lastKey;
	private Game game;

	public Controller() {
		managerUser = new ManagerUser();
		principalFrame = new PrincipalFrame(this);
		reviewRequest();
	}

	private void reviewRequest() {
		Timer timer = new Timer(600000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Node<Game> request = managerUser.getRequest();
				if (request != null) {
					managerUser.buyGame(request.getInfo());
				}
			}
		});
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringTokenizer st = new StringTokenizer(e.getActionCommand(), " ");
		if (st.nextToken().equals("g")) {
			game = new Game(st.nextToken(), Integer.parseInt(st.nextToken()));
		} else {
			switch (CommandApp.valueOf(e.getActionCommand())) {
			case COMMAND_ADD:
				managerUser.addGame(
						new Game(principalFrame.getGameInfo()[0], Integer.parseInt(principalFrame.getGameInfo()[1])));
				principalFrame.setGameField();
				principalFrame.loadGameList(managerUser.getGameList());
				break;
			case COMMAND_BUY:
				managerUser.buyGame(game);
				principalFrame.loadUserList(managerUser.getUserList(), managerUser.getCredits());
				principalFrame.loadGameList(managerUser.getGameList());
				break;
			case COMMAND_CANCEL_REFUND:
				managerUser.cancelRefund();
				principalFrame.loadUserList(managerUser.getUserList(), managerUser.getCredits());
				principalFrame.loadGameList(managerUser.getGameList());
				break;
			case COMMAND_REFUND:
				managerUser.refund();
				principalFrame.loadUserList(managerUser.getUserList(), managerUser.getCredits());
				principalFrame.loadGameList(managerUser.getGameList());
				break;
			case COMMAND_DELETE:
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println(key.getKeyChar());
		if (lastKey == KeyEvent.VK_ALT) {
//			if (key.getKeyCode() == KeyEvent.VK_Z) {
//				managerUser.cancelRefund();
//				principalFrame.loadUserList(managerUser.getUserList(), managerUser.getCredits());
//			} else if (key.getKeyCode() == KeyEvent.VK_Y) {
//				managerUser.refund();
//				principalFrame.loadUserList(managerUser.getUserList(), managerUser.getCredits());
//			}
		}
		lastKey = key.getKeyCode();
		System.out.println(lastKey);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent key) {
	}

}