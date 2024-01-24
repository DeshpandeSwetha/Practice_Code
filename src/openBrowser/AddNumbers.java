package openBrowser;

public class AddNumbers 
{

	public static void main(String[] args) 
	{
		      int x[] = new int[10];
		      int y = 2;
		      for(int i=0; i<x.length; i++)
		      {
		          x[i]=y;
		          y=y+2;
		      }
		      
		      for(int i=0; i<x.length; i++)
		      {
		          System.out.println(x[i]);
		      }

		      System.out.println("all numbers are entered");
		}

	}