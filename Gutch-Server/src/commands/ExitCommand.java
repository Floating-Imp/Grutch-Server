package commands;

import processor.Data;
import receiver.Server;

public class ExitCommand extends Command
{

	public ExitCommand()
	{
		super("exit");
	}

	@Override
	public Data execute(Data data)
	{
		data.setUsername("");
		data.setOutput(data.getUsername() + " has left.");
		
		Server.removeUser(data.getAddress());
		
		return data;
	}

}
