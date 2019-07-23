public class Item {
	private String name;
	private String price;
	private String stock;
	
	Item(String product, String cost, String info)
	{
		name = product;
		price = cost;
	}
	Item(String product)
	{
		name = product;
		price = null;
	}
	
	void setname(String product)
	{
		name = product;
	}
	void setprice(String cost)
	{
		price = cost;
	}

	
	String getname()
	{
		return name;
	}

	String getprice()
	{
		return price;
	}
	
	public String toString()
	{
		return "\n" + getname() + " " + getprice();
	}

}
