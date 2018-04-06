package view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;
import controller.CommandApp;
import controller.ConstantList;
import controller.Controller;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private PanelGame gameList;
	private PanelGame userGameList;
	private JLabel labelCredits;
	private PanelAddGame panelAddGame;

	public PrincipalFrame(Controller controller) throws HeadlessException {
		this.controller = controller;
		setTitle(ConstantList.APP_NAME);
		setIconImage(new ImageIcon(ConstantList.ICON_URL).getImage());
		setLayout(new BorderLayout());
		setFocusable(true);
		addKeyListener(controller);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}

	private void init() {
		panelAddGame = new PanelAddGame(controller);
		add(panelAddGame, BorderLayout.NORTH);
		add(new PanelAction(controller), BorderLayout.SOUTH);
		panelUser();
		JPanel panel = new JPanel(new BorderLayout());
		panel.addKeyListener(controller);
		panel.setFocusable(true);
		panel.add(UtilityList.createJLabel(ConstantList.GAMES, ConstantList.TITLE_FONT, ConstantList.APP_COLOR),
				BorderLayout.NORTH);
		gameList = new PanelGame(controller);
		panel.add(gameList, BorderLayout.CENTER);
		panel.add(UtilityList.createJButtonText(CommandApp.COMMAND_BUY.getCommand(), CommandApp.COMMAND_BUY.getTitle(),
				ConstantList.APP_COLOR, ConstantList.WORD_FONT, controller), BorderLayout.SOUTH);
		add(panel, BorderLayout.EAST);
		setVisible(true);
	}

	private void panelUser() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.addKeyListener(controller);
		panel.setFocusable(true);
		panel.add(UtilityList.createJLabel(ConstantList.USER, ConstantList.TITLE_FONT, ConstantList.APP_COLOR),
				BorderLayout.NORTH);
		userGameList = new PanelGame(controller);
		labelCredits = new JLabel();
		panel.add(labelCredits, BorderLayout.SOUTH);
		panel.add(userGameList, BorderLayout.CENTER);
		panel.add(UtilityList.createJButtonText(CommandApp.COMMAND_DELETE.getCommand(),
				CommandApp.COMMAND_DELETE.getTitle(), ConstantList.APP_COLOR, ConstantList.WORD_FONT, controller),
				BorderLayout.SOUTH);
		add(panel, BorderLayout.WEST);

	}

	public void loadUserList(ArrayList<Game> list, int credits) {
		userGameList.loadGames(list, list.size(), 1);
		labelCredits.setText(String.valueOf(credits));
		getContentPane().repaint();
	}

	public void loadGameList(ArrayList<Game> list) {
		gameList.loadGames(list, list.size(), 1);
		getContentPane().repaint();
	}

	public String[] getGameInfo() {
		return panelAddGame.getGameInfo();
	}

	public void setGameField() {
		panelAddGame.setGameField();
		getContentPane().repaint();
	}
}