package controller;

public enum CommandApp {

	COMMAND_ADD("COMMAND_ADD", "Agregar"),
	COMMAND_DELETE("COMMAND_DELETE", "Eliminar"),
	COMMAND_BUY("COMMAND_BUY", "Comprar"), 
	COMMAND_REFUND("COMMAND_REFUND", "Devolver"),
	COMMAND_CANCEL_REFUND("COMMAND_CANCEL_REFUND", "Cancelar");

	private String command;
	private String title;

	private CommandApp(String command, String title) {
		this.command = command;
		this.title = title;
	}

	public String getCommand() {
		return command;
	}

	public String getTitle() {
		return title;
	}
}