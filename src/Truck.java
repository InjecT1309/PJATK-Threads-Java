import java.lang.Thread;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Exception;

public class Truck extends Thread
{
	private ArrayList<Factory> factory_list;
	private ArrayList<Car> cars_loaded;
	private ArrayList<Car> cars_delivered;
	private File log;
	private PrintWriter log_writer;
	private static final boolean debug = false;
	
	private class IllegalIdException extends Exception 
	{
		private static final long serialVersionUID = 1L;
	}
	
	public Truck(ArrayList<Factory> f_l)
	{
		factory_list = f_l;
		cars_loaded = new ArrayList<Car>();
		cars_delivered = new ArrayList<Car>();
		initLog();
	}
	@Override
	public void run()
	{
		while(!checkIfAllFactoriesFinished())
		{
			for(Factory f : factory_list)
			{
				takeCars(f);
			}
			deliverCars();
		}
		log_writer.close();
	}
	private boolean initLog()
	{
		try 
		{
			log = new File("log.txt");
			
			if(log.exists())
				log.delete();
			
			log.createNewFile();
			
			log_writer = new PrintWriter(log);
			
			return true;
		} 
		catch(IOException e)
		{
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	private boolean checkIfAllFactoriesFinished()
	{
		for(Factory f : factory_list)
			if(!f.finished)	return false;
		return true;
	}
	private void takeCars(Factory f)
	{
		if(f.parking_spots.size()==2)
		{
			Car c;
			for(int i=0; i<f.parking_spots.size(); i++)
			{
				c = f.parking_spots.get(i);
				cars_loaded.add(c);
				if(debug)
					System.out.println(c+" taken");
				log_writer.println(c+" taken");
			}
			f.parking_spots.clear();

			synchronized(f)
			{
				f.notify();
			}
		}
	}
	private void deliverCars()
	{
		for(Car c : cars_loaded)
		{
			try
			{
				validateCar(c);
				cars_delivered.add(c);
				
				if(debug)
					System.out.println(c+" left");
				log_writer.println(c+" left");
			}
			catch(IllegalIdException e)
			{
				System.out.println("Illegal car ID");
			}
		}
		cars_loaded.clear();
	}
	private void validateCar(Car c) throws IllegalIdException
	{
		for(Car other : cars_delivered)
			if(c.compareTo(other)==0)
				throw new IllegalIdException();
	}
}
