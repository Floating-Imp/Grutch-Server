package commands.serverCommands;

public enum ServerCommands
{
	kick (new KickCommand()),
	say (new SayCommand()),
	who (new WhoCommand()),
	exit (new ExitCommand());
	
	private ServerCommand command;
	
	private ServerCommands(ServerCommand c)
	{
		command = c;
	}
	
	public ServerCommand getValue()
	{
		return command;
	}
}
