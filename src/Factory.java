import java.lang.Thread;
import java.util.ArrayList;

public abstract class Factory extends Thread
{
	MyList<Car> parking_spots;
	boolean finished;
	protected static final boolean debug = false;
	
	public Factory()
	{
		parking_spots = new MyList<Car>();
		finished = false;
	}
	
	@Override
	public void run()
	{
		for(int produced = 0; produced < 1000; produced++)
		{
			produceCar();
			if(parking_spots.size() == 2)
			{
				try
				{
					synchronized(this)
					{
						wait();
					}
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getStackTrace());
				}
			}
		}
		
		finished = true;
		if(debug)
			System.out.println("Done");
	}
	
	protected abstract void produceCar();
}
