package receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import processor.BaseProcessing;

public class Server
{
	private static DatagramSocket server;
	
	public Server()
	{
		try
		{
			server = new DatagramSocket(1001);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		DatagramPacket temp = new DatagramPacket(null, 0);
		
		try
		{
			server.receive(temp);
			
			new Thread(new BaseProcessing(temp)).start();
		}
		catch (IOException e)
		{
			//Server failed to accept.
			e.printStackTrace();
		}
	}
	
	public static void broadcast(String data) throws SocketException
	{
		for (InetAddress ia: Connected.getKeySet())
		{
			try
			{
				server.send(new DatagramPacket(data.getBytes(), data.getBytes().length, ia, Connected.get(ia)));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(InetAddress address, int port)
	{
		DatagramPacket p = new DatagramPacket("disconnect".getBytes(), "disconnect".getBytes().length, address, port);
		try
		{
			server.send(p);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
