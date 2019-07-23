import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Extract {
	
	Document document;
	Elements harvester;
	
	void getData(ArrayList<Item> products, String url)
	{
		try {
			document = Jsoup.connect(url).userAgent("user").get();
			harvester = document.select("h4.sku-header");
			for(Element runner : harvester)
			{
				products.add(new Item(runner.text()));
			}
			int count = 0;
			harvester = document.select("div.priceView-customer-price");
			for(Element runner : harvester.select("span[aria-hidden = true]"))
			{
				products.get(count).setprice(runner.text());
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
