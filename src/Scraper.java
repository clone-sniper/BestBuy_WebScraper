import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Scraper {
	public static void main (String args[]) throws Exception
	{
		System.out.println("running");
		ArrayList<Item> product = new ArrayList<>();
		String url = "https://www.bestbuy.com/site/headphones/noise-canceling-headphones/pcmcat1506545802590.c?id=pcmcat1506545802590&qp=headphonefit_facet%3DHeadphone%20Fit~Over-the-Ear";
		new Extract().getData(product, url);
		for(Item runner : product)
		{
			System.out.println(runner.toString());
		}
		Connection conn = new StoreData().getConnection();
		new StoreData().createtable(conn);
		new StoreData().insert(product, conn);
		System.out.println("done ");
	}

}
