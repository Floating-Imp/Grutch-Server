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
	
	private static Server instance;
	
	private Server()
	{
		try
		{
			server = new DatagramSocket(1001);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		DatagramPacket temp = new DatagramPacket("".getBytes(), 0);
		
		
		try
		{
			while (true)
			{
				System.out.println("Listening...");
				server.receive(temp);
			
				new Thread(new BaseProcessing(temp)).start();
			}
		}
		catch (IOException e)
		{
			//Server failed to accept.
			e.printStackTrace();
		}
	}
	
	public static Server getInstance()
	{
		if (instance == null)
		{
			instance = new Server();
		}
		
		return instance;
	}
	
	public static void broadcast(String data, InetAddress exclude) throws SocketException
	{
		for (InetAddress ia: Connected.getKeySet())
		{
			if (ia.equals(exclude))
			{
				continue;
			}
			try
			{
				System.out.println("Sending: " + data);
				System.out.println("To: " + ia.getHostAddress());
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
