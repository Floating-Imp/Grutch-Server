package processor;

public enum Command
{
	me ("me"),
	exit ("exit");
	
	private String value;
	
	private Command(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
