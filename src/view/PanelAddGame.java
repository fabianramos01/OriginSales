package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CommandApp;
import controller.ConstantList;
import controller.Controller;

public class PanelAddGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField gameField;
	private JTextField versionField;

	public PanelAddGame(Controller controller) {
		setLayout(new GridLayout(1, 5));
		setFocusable(true);
		addKeyListener(controller);
		add(UtilityList.createJLabel(ConstantList.GAME_TITLE, ConstantList.WORD_FONT, ConstantList.APP_COLOR));
		gameField = new JTextField();
		add(gameField);
		add(UtilityList.createJLabel(ConstantList.GAME_VERSION, ConstantList.WORD_FONT, ConstantList.APP_COLOR));
		versionField = new JTextField();
		add(versionField);
		add(UtilityList.createJButtonText(CommandApp.COMMAND_ADD.getCommand(), CommandApp.COMMAND_ADD.getTitle(),
				ConstantList.APP_COLOR, ConstantList.WORD_FONT, controller));
	}
	
	public String[] getGameInfo() {
		String[] info = { gameField.getText(), versionField.getText() };
		return info;
	}

	public void setGameField() {
		gameField.setText("");
		versionField.setText("");
	}
}