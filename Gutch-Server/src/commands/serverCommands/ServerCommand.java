package commands.serverCommands;

public abstract class ServerCommand
{	
	private final String keyText;
	
	public ServerCommand(String commandText)
	{
		this.keyText = commandText;
	}
	
	public String getCommandText()
	{
		return keyText;
	}
	
	
	/**
	 * Executes the command
	 * @param packet The packet that was sent.
	 * @return The modified data
	 */
	public abstract void execute(String args);
}
