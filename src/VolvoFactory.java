
public class VolvoFactory extends Factory
{
	@Override
	protected void produceCar()
	{
		parking_spots.add(new Volvo());
		if(debug)
			System.out.println("New Volvo produced");
	}
}
