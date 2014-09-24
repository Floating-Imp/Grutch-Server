package commands.serverCommands;

import receiver.Server;
import users.User;

public class WhoCommand extends ServerCommand
{

	public WhoCommand()
	{
		super("who");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String args)
	{
		for (User u : Server.getUsers())
		{
			Server.print(u.getUsername());
		}
	}

}
