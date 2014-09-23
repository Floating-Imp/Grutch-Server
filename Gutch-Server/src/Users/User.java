package Users;
import java.awt.Color;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class User
{
	private InetAddress ip;
	private int port;
	private Color color;
	private String username;
	
	public User(DatagramPacket packet)
	{
		this.username = new String(packet.getData()).trim().split("\\|")[0];
		this.ip = packet.getAddress();
		this.port = packet.getPort();
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
	
	public String getUsername()
	{
		return this.username;
	}
}
