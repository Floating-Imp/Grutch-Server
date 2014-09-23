package commands;

import processor.Data;
import receiver.Server;
import users.User;

public class KickCommand extends Command
{

	public KickCommand()
	{
		super("kick");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Data execute(Data data)
	{
		String userToKick = data.getText().split(" ")[1];
		
		String reason;
		
		try
		{
			@SuppressWarnings("unused")
			String ignored = data.getText().split(" ")[2];
		
			reason = data.getText().replace(data.getText().split(" ")[1], "");
			reason = reason.replace(data.getText().split(" ")[0], "");
			
		}
		catch (IndexOutOfBoundsException e)
		{
			reason = null;
		}
		
		for(User u : Server.getUsers())
		{
			if (u.getUsername().equals(userToKick))
			{
				data.setData(userToKick + " has been kicked by " + data.getUsername() + (reason != null ? " for" + reason + "." : "."));
				data.setUsername("");
				Server.disconnect(u.getIP(), u.getPort());
			}
		}
		
		return data;
	}

}
