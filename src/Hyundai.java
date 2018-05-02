
public class Hyundai extends Car
{
	static private int carIdInit = 3000;
	int maxMilesPerHour = 100;
	
	public Hyundai()
	{
		carId = carIdInit;
		carIdInit++;
	}
	@Override
	public String toString()
	{
		return carId + " Hyundai";
	}
}
