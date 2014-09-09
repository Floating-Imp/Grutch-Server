package processor;

import java.net.DatagramPacket;
import java.net.SocketException;

import receiver.Connected;
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
		System.out.println("InetAddress: " + packet.getAddress());
		Connected.add(packet.getAddress(), packet.getPort());
		
		System.out.println("Doing things.");
		String data = packet.getData().toString();
		
		try
		{
			Server.broadcast(data, packet.getAddress());
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
	}
}
