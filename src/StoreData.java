import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class StoreData {
	
	public static Connection getConnection() throws Exception
	{
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/bestbuy";
			String user = "tester";
			String pass = "password";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	
	public static void createtable(Connection conn) throws Exception
	{
		try {
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS products(name varchar(255),price varchar(10),PRIMARY KEY (name));");
			create.executeUpdate();
			System.out.println("Table Created");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insert(ArrayList<Item> products, Connection conn) throws Exception
	{
		try {
			for(Item runner: products)
			{
				PreparedStatement inserting = conn.prepareStatement("REPLACE INTO products(name, price) VALUES ('"+runner.getname()+"' , '"+runner.getprice()+"');");
				inserting.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
