import java.lang.Comparable;

public abstract class Car implements Comparable<Car> 
{
	protected int carId;
	
	@Override
	public int compareTo(Car other)
	{
		if(this.carId == other.carId)	return 0;
		else	return this.carId > other.carId ? 1 : -1;
	}
}
