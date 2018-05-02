
public class Volvo extends Car
{
	static private int carIdInit = 1000;
	String fuelType = "Electric";
	
	public Volvo()
	{
		carId = carIdInit;
		carIdInit++;
	}
	@Override
	public String toString()
	{
		return carId + " Volvo";
	}
}
