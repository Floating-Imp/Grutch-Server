package commands;

import java.awt.Color;

import processor.Data;

public class HelpCommand extends Command
{

	public HelpCommand()
	{
		super("help");
	}

	@Override
	public Data execute(Data data)
	{
		String commandNames = "";
		
		for (Commands c : Commands.values())
		{
			commandNames += "\n" + c.getValue().getCommandText();
		}
		
		data.setUsername("");
		data.setColor(Color.YELLOW);
		data.setOutput("To use commands type \"" + Command.getCommandChar() + "\" and the command name."
				+ "The commands are: " + commandNames);
		return data;
	}

}
