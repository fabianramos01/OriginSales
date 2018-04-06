package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CommandApp;
import controller.ConstantList;
import controller.Controller;

public class PanelAction extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelAction(Controller controller) {
		setLayout(new GridLayout(1, 1));
		JButton button = UtilityList.createJButtonText(CommandApp.COMMAND_REFUND.getCommand(),
				CommandApp.COMMAND_REFUND.getTitle(), ConstantList.APP_COLOR, ConstantList.WORD_FONT, controller);
		button.addActionListener(controller);
		add(button);
		button = UtilityList.createJButtonText(CommandApp.COMMAND_CANCEL_REFUND.getCommand(),
				CommandApp.COMMAND_CANCEL_REFUND.getTitle(), ConstantList.APP_COLOR, ConstantList.WORD_FONT, controller);
		button.addActionListener(controller);
		add(button);
	}
}
