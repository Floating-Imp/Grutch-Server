package commands.serverCommands;

import java.awt.Color;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import processor.Data;
import receiver.Server;

public class SayCommand extends ServerCommand
{

	public SayCommand()
	{
		super("say");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String args)
	{
		String[] array = args.split(" ");
		
		String temp = "";
		
		for (int i = 1; i < array.length; i++)
		{
			temp += array[i] + " ";
		}
		
		try
		{
			Server.broadcast((new Data(temp, "[SERVER]", Color.MAGENTA, InetAddress.getLocalHost())).getData());
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
	}

}
