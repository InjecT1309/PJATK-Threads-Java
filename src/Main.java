import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		Factory f = new VolvoFactory();
		Factory g = new SkodaFactory();
		Factory h = new HyundaiFactory();
		
		ArrayList<Factory> list = new ArrayList<Factory>();
		list.add(f);
		list.add(g);
		list.add(h);
		
		Truck t = new Truck(list);
		
		f.start();
		g.start();
		h.start();
		t.start();
	}
}
