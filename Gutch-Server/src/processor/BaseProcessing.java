package processor;

import java.io.UnsupportedEncodingException;
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
		System.out.println("Connected ips: " + Connected.getKeySet().toString());
		Connected.add(packet.getAddress(), packet.getPort());
		System.out.println("Connected ips: " + Connected.getKeySet().toString());
		System.out.println("Doing things.");
		String data = "Failed";
		try
		{
			data = new String(packet.getData(), "UTF-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (data.contains("has left."))
		{
			Connected.remove(packet.getAddress());
		}
		
		try
		{
			Server.broadcast(data, packet.getAddress(), packet.getPort());
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
	}
}
