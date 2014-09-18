package processor;

import java.awt.Color;
import java.net.InetAddress;

public class Data
{
	private String text;
	private String username;
	private Color color;
	private InetAddress ip;
	
	private boolean isStandard;
	
	public Data(String info, String username, Color c, InetAddress ip)
	{
		this.text = info;
		this.username = username;
		this.color = c;
		isStandard = true;
		this.ip = ip;
	}
	
	public byte[] getData()
	{
		return (username + "|" + text + "|" + color.getRed() + "," + color.getGreen() + "," + color.getBlue()).getBytes();
	}
	
	public void setData(String info, String username, Color c)
	{
		this.text = info;
		this.username = username;
		this.color = c;
	}
	
	public void setData(String info, String username)
	{
		this.text = info;
		this.username = username;
	}
	
	public void setData(String info)
	{
		this.text = info;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setColor(Color c)
	{
		this.color = c;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public String toString()
	{
		if (isStandard)
		{
			return "[" + username + "]: " + this.text;
		}
		
		return this.text;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setOutput(String s)
	{
		this.isStandard = false;
		this.text = s;
	}
	
	public InetAddress getAddress()
	{
		return this.ip;
	}
}
