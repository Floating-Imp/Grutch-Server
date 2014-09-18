package Users;
import java.awt.Color;
import java.net.InetAddress;

public class User
{
	private InetAddress ip;
	private int port;
	private Color color;
	
	public User(InetAddress ip, int port)
	{
		this.ip = ip;
		this.port = port;
		this.color = Color.WHITE;
	}
	
	public void setColor(Color c)
	{
		this.color = c;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public InetAddress getIP()
	{
		return this.ip;
	}
	
	public int getPort()
	{
		return this.port;
	}
}
