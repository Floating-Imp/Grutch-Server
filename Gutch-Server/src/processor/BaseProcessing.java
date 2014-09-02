package processor;

import java.net.DatagramPacket;

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
		packet.getData().toString();
	}
}
