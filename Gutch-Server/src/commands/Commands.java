package commands;

public enum Commands
{
	me (new MeCommand()),
	exit (new ExitCommand()),
	color (new ColorCommand()),
	help (new HelpCommand());
	
	private Command command;
	
	private Commands(Command c)
	{
		command = c;
	}
	
	public Command getValue()
	{
		return command;
	}
}
