package openBrowser;

import java.util.ArrayList;

public class AddStrings 
{

	public static void main(String[] args) 
	{
		ArrayList<String> products = new ArrayList<String>();
		products.add("Cookies");
		products.add("Chocolates");
		products.add("Ice-creams");
		products.add("Cold Drinks");
		products.add("Choco chips");
		
		for(int i=0; i<products.size();i++)
		{
			System.out.println(products.get(i));
		}

	}

}
