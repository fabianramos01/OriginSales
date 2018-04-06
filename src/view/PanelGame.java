package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ConstantList;
import controller.Controller;
import model.Game;

public class PanelGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controller controller;

	public PanelGame(Controller controller) {
		this.controller = controller;
	}

	public void loadGames(ArrayList<Game> list, int x, int y) {
		removeAll();
		updateUI();
		setLayout(new GridLayout(x, y));
		for (Game game : list) {
			add(UtilityList.createJButtonText("g " + game.getName() + " " + game.getVersion(),
					game.getName() + " " + game.getVersion(), Color.BLACK, ConstantList.WORD_FONT, controller));
		}
	}
}