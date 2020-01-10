public class Karel
{
	//instance variables
	private int x;
	private int y;

	//constructor
	public Karel(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	//methods
	public void moveRight()
	{
		x++;
	}

	public void moveLeft()
	{
		x--;
	}

	public void moveUp()
	{
		y++;
	}

	public void moveDown()
	{
		y--;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	//test client
	public static void main(String[] args)
	{
		StdDraw.setScale(-10.0, +10.0);
		Karel myRobot = new Karel(0, 0);
		StdDraw.filledCircle(myRobot.getX(), myRobot.getY(), 0.2);
	}
}