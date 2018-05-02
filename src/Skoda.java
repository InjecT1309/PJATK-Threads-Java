
public class Skoda extends Car
{
	static private int carIdInit = 2000;
	boolean hasGPS = true;
	
	public Skoda()
	{
		carId = carIdInit;
		carIdInit++;
	}
	@Override
	public String toString()
	{
		return carId + " Skoda";
	}
}
