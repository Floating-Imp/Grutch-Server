package commands;

import java.awt.Color;
import java.lang.reflect.Field;

import Users.User;
import processor.Data;
import receiver.Server;

public class ColorCommand extends Command
{

	public ColorCommand()
	{
		super("color");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Data execute(Data data)
	{
		String[] strings = data.getText().split(" ");
		Color color = Color.black;
		
		
		
		if (strings.length >= 1)
		{
			try
			{
				color = stringToColor(strings[1]);
			}
			catch (NoSuchFieldException e)
			{
				return null;
			}
			catch (SecurityException e)
			{
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		
		for (User u : Server.getUsers())
		{
			if (u.getIP().equals(data.getAddress()))
			{
				u.setColor(color);
			}
		}
		
		return null;
	}
	
	public static Color stringToColor(String string) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Color.class.getField(string);
		return (Color)f.get(null);
	}

}
