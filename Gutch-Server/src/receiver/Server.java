package receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import processor.BaseProcessing;
import users.User;

public class Server
{
	private static DatagramSocket server;
	
	private static Server instance;
	
	private static List<User> users = new ArrayList<User>();
	
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
		try
		{
			while (true)
			{
				DatagramPacket temp = new DatagramPacket(new byte[2048], 2048);
				Server.print("Listening...");
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
	
	public synchronized static void broadcast(byte[] data) throws SocketException
	{

		for (User u : users)
		{
			try
			{
				Server.print("To: " + u.getIP() + ":" + (u.getPort() + 1));
				server.send(new DatagramPacket(data, data.length, u.getIP(), u.getPort() + 1));
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
	
	public static List<User> getUsers()
	{
		return users;
	}
	
	public static void removeUser(InetAddress ip)
	{
		for (User u : users)
		{
			if (u.getIP().equals(ip))
			{
				users.remove(u);
			}
		}
	}
	
	public static synchronized void print(String s)
	{
		System.out.println(s);
	}
}
