import receiver.Server;
import receiver.ServerIO;

public class Main
{
	public static void main(String[] args)
	{
		new Thread(new ServerIO()).start();
		
		Server.getInstance().start();
	}
}
