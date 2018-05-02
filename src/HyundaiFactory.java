
public class HyundaiFactory extends Factory
{
	@Override
	protected void produceCar()
	{
		parking_spots.add(new Hyundai());
		if(debug)
			System.out.println("New Hyundai produced");
	}
}