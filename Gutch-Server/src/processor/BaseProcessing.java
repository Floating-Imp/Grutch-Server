package processor;

import java.net.DatagramPacket;
import java.net.SocketException;

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
		String data = packet.getData().toString();
		
		try
		{
			Server.broadcast(data);
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
	}
}
