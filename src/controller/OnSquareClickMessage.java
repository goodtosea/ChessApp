package controller;

public class OnSquareClickMessage implements Message
{
	private int x, y;
	
	public OnSquareClickMessage(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	public int getX()
	{
		return this.x;
	}
	
	
	public int getY()
	{
		return this.y;
	}
	
}
