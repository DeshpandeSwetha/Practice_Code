package openBrowser;

import java.util.Arrays;

public class test 
{
	public static void main(String[] args) 
	{
        int[] ar = {1,423,6,46,34,23,13,53,4};
		
		/*int max = ar[0];
		int min = ar[0];
		
		for(int i=0; i<ar.length; i++)
		{
			if(ar[i]>max)
			{
				max=ar[i];
			}
			if(ar[i]<min)
			{
				min = ar[i];
			}
		}
		System.out.println("Max is :"+max+"Min is"+min);*/
        
        //Implement inbuilt function to sort the array
        Arrays.sort(ar);
        
        //After sorting, the 0th position will have the minimum value and the nth position will have the max. value
        System.out.println("Min-:"+ar[0]+"Max-:"+ar[ar.length-1]);        
	}
}
