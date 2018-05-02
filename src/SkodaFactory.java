
public class SkodaFactory extends Factory
{
	@Override
	protected void produceCar()
	{
		parking_spots.add(new Skoda());
		if(debug)
			System.out.println("New Skoda produced");
	}
}