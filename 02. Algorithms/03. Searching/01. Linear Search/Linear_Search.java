// TODO: Search an Element in the array using Linear Search Technique
package array.searching;

public class Linear_Search {

	static int linearSearch(int[] arr, int element) {
		if(arr.length == 0)
			return -1;
		
		for(int i = 0; i < arr.length; i++)
		{
			// find the first occurrence of the element and return it's position
			if(arr[i] == element) {
				return i + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = { 18, 12, 9, 14, 77, 50, 45, 2, 91, 40};
		int element = 9;
		int res = linearSearch(arr, element);
		if(res == -1)
			System.out.println("Element not Found");
		else
			System.out.println("Element Found at position " + res);
	}
}
