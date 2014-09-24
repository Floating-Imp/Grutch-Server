package receiver;

import java.util.Scanner;

import commands.serverCommands.ServerCommands;

public class ServerIO implements Runnable
{
	private Scanner in;
	
	public ServerIO()
	{
		in = new Scanner(System.in);
	}	
	
	@Override
	public void run()
	{
		while(true)
		{
			if (in.hasNext())
			{
				String temp = in.nextLine();
				for (ServerCommands c : ServerCommands.values())
				{
					if ((temp.toLowerCase()).contains(c.getValue().getCommandText()))
					{
						c.getValue().execute(temp);
					}
				}
			}
		}
	}

}
