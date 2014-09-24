package commands.serverCommands;

import java.awt.Color;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import processor.Data;
import receiver.Server;
import users.User;

public class KickCommand extends ServerCommand
{

	public KickCommand()
	{
		super("kick");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String args)
	{
		String userToKick = args.split(" ")[1];
		
		String reason;
		
		try
		{
			@SuppressWarnings("unused")
			String ignored = args.split(" ")[2];
		
			reason = args.replace(args.split(" ")[1], "");
			reason = reason.replace(args.split(" ")[0], "");
			
		}
		catch (IndexOutOfBoundsException e)
		{
			reason = null;
		}
		
		for(User u : Server.getUsers())
		{
			if (u.getUsername().equals(userToKick))
			{
				try
				{
					Server.broadcast((new Data(userToKick + " has been kicked" + (reason != null ? " for" + reason + "." : "."), "[SERVER]", Color.MAGENTA, InetAddress.getLocalHost()).getData()));
				}
				catch (SocketException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (UnknownHostException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Server.disconnect(u.getIP(), u.getPort());
			}
		}
	}

}
