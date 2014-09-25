package commands.serverCommands;

import receiver.Server;

public class ExitCommand extends ServerCommand
{

	public ExitCommand()
	{
		super("exit");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String args)
	{
		Server.stop();
	}
	
}
