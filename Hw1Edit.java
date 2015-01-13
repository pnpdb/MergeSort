import java.util.Arrays;

/**
 * Class to demonstrate 3 way merge sort.
 * @author Mark Santiago
 */

public class Hw1Edit
{
	public static void main (String args[])
	{	
		int[] data = new int[args.length];
		for (int i = 0; i < args.length; i++)
		{
			int element = Integer.parseInt(args[i]);
			data[i] = element;
		}
        sort(data);
	}
	
	/**
	 * Method to sort given data
	 * @param data the elements inputed by the user
	 * @return the data after it is sorted
	 */
	public static int[] sort(int[] data) 
	{	
		System.out.println("Input:" + Arrays.toString(data));
		
		//Returns sequence of a single element or empty sequence
		if (data.length <= 1)
		{
			System.out.println("Sorted:" + Arrays.toString(data));
			return data;
		}
		
		//Sorts sequences of length 2 and returns the sequence
		else if (data.length == 2)
		{
			if (data[0] > data[1])
			{
				int temp = data[1];
				data[1] = data[0];
				data[0] = temp;
			}
			System.out.println("Sorted:" + Arrays.toString(data));
			return data;
		}
		
		else
		{
			/*
			 * Makes 3 different arrays if the number of elements in the sequence is 3 or more.
			 * The length of each array is one third of the original array's length, as well as the
			 * remainder of the elements.
			 * Each array is then sorted.	
			 */
			int[] begin = Arrays.copyOfRange(data, 0, data.length / 3); 
			int[] middle = Arrays.copyOfRange(data, begin.length, 2 * data.length / 3);
			int[] end =  Arrays.copyOfRange(data, begin.length + middle.length, data.length);
			
			System.out.println("Subsequences:");
			System.out.println(Arrays.toString(begin));
			System.out.println(Arrays.toString(middle));
			System.out.println(Arrays.toString(end));
			
			begin = sort(begin);
			middle = sort(middle);
			end = sort(end);
			
			return threeWayMerge(data, begin, middle, end); //Merges the arrays
		}
	}
	
	/**
	 * Merges 3 sorted arrays into a single array
	 * @param data the resulting array after all 3 arrays have been merged and sorted
	 * @param begin the first sorted array
	 * @param middle the second sorted array
	 * @param end the third sorted array
	 */
	private static int[] threeWayMerge(int[] merged, int[] begin, int[] middle, int[] end)
	{
		int dataSize = begin.length + middle.length + end.length; //Total length
		merged = new int[dataSize]; //The final array where everything has been merged and sorted
		int bNum = 0; //Next element in the beginning array
		int mNum = 0; //Next element in the middle array
		int eNum = 0; //Next element in the ending array
		
		
		for (int i = 0; i < merged.length; i++)
		{
			boolean bDone = false; //Checks if all elements in beginning array are used
			boolean mDone = false; //Checks if all elements in middle array are used
			boolean eDone = false; //Checks if all elements in end array are used
			//Returns array after all elements have been sorted and used
			if (bDone == true && mDone == true && eDone == true)
			{
				return merged;
				
			}
			
			else
			{
				/*
				 * Checks if the next element of the beginning array has the smallest value
				 * compared to the next elements of the other arrays.
				 */
				if (begin[bNum] <= middle[mNum] && begin[bNum] <= end[eNum])
				{
					//Sets the next element of the merged array with that of the next beginning array element
					merged[i] = begin[bNum];
					if (bNum == begin.length - 1) //Checks if all elements of the beginning array were used
					{
						bDone = true;
					}
					else
					{
						bNum++; //Goes to the next element of the sorted beginning array
					}	
				}
			
				/*
				 * Checks if the next element of the middle array has the smallest value
				 * compared to the next elements of the other arrays.
				 */
				else if (middle[mNum] <= begin[bNum] && middle[mNum] <= end[eNum])
				{
					//Sets the next element of the merged array with that of the next middle array element
					merged[i] = middle[mNum];
					if (mNum == middle.length - 1)//Checks if all elements of the middle array were used
					{
						mDone = true;
					}
					else
					{
						mNum++; //Goes to the next element of the sorted middle array
					}	
				}
			
				/*
				 * Checks if the next element of the end array has the smallest value
				 * compared to the next elements of the other arrays.
				 */
				else if (end[eNum] <= begin[bNum] && end[eNum] <= middle[mNum])
				{
					//Sets the next element of the merged array with that of the next end array element
					merged[i] = end[eNum];
					if (eNum == end.length - 1) //Checks if all elements of the end array were used
					{
						eDone = true;
					}
					else
					{
						eNum++; //Goes to the next element of the sorted end array
					}	
				}
			}
		}
		
		bDone = false;
		mDone = false;
		eDone = false;
		System.out.println("Sorted:" + Arrays.toString(merged));
		
	}
	 
}
