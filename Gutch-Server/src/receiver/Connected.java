package receiver;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Connected
{
	private static Map<InetAddress, Integer> connected = new HashMap<InetAddress, Integer>();
	
	public static void add(InetAddress address, int port)
	{
		connected.put(address, port);
	}
	
	public static void remove(InetAddress address)
	{
		connected.remove(address);
	}
	
	public static int get(InetAddress address)
	{
		return connected.get(address);
	}
	
	public static Set<InetAddress> getKeySet()
	{
		return connected.keySet();
	}
}
