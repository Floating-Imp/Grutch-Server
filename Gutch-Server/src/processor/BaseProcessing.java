package processor;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.SocketException;

import commands.Command;
import commands.Commands;

import Users.User;
import receiver.Server;

public class BaseProcessing implements Runnable
{
	
	private DatagramPacket packet;
	
	public BaseProcessing(DatagramPacket packet)
	{
		this.packet = packet;
	}
	
	@Override
	public void run()
	{
		User currentUser = new User(packet.getAddress(), packet.getPort());
		
		boolean userExists = false;
		
		for (User u : Server.getUsers())
		{
			if (u.getIP().equals(packet.getAddress()) && u.getPort() == packet.getPort())
			{
				userExists = true;
				currentUser = u;
			}
		}
		
		if (!userExists)
		{
			Server.getUsers().add(currentUser);
		}
		
		String packetData = "";
		try
		{
			packetData = new String(packet.getData(), "UTF-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		packetData = packetData.trim();
		
		Data data = new Data(packetData.split("\\|")[1], packetData.split("\\|")[0], currentUser.getColor(), packet.getAddress());
		
		for (Commands c : Commands.values())
		{
			if (data.getText().startsWith(Command.getCommandChar() + c.getValue().getCommandText()))
			{
				data = c.getValue().execute(data);
				break;
			}
		}
		
		try
		{
			if (data != null && data.getData() != null)
			{
				Server.broadcast(data.getData());
			}
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
	}
}
