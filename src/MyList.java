
public class MyList<T>
{
	private class MyObject<T>
	{
		T value;
		MyObject<T> next = null;
		
		MyObject()
		{

		}
		MyObject(T val)
		{
			value = val;
		}
		public MyObject<T> getLast()
		{
			MyObject<T> output = this;
			while(output.next != null)
				output = output.next;
			return output;
		}
		public int howManyMore()
		{
			int output=0;
			MyObject<T> tmp = this;
			while(tmp.next != null)
			{
				tmp = tmp.next;
				output++;
			}
			return output;
		}
	}
	
	MyObject<T> first = null;
	
	public void add(T element)
	{
		if(first == null)	first = new MyObject<T>(element);
		else				first.getLast().next = new MyObject<T>(element);
	}
	public int size()
	{
		return first == null ? 0 : first.howManyMore()+1;	//also the first element
	}
	public void clear()
	{
		first = null;
	}
	public T get(int iter)
	{
		MyObject<T> output = first;
		for(int i=0; i<iter; i++)
			output = output.next;
		return output.value;
	}
}
