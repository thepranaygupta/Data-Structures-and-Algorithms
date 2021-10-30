### Problem Link: https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

- ## Iterative Approach:

```java
import java.util.Arrays;

public class ReverseArray {
	public static int[] reverseIteratively(int arr[], int length) {
		int s = 0, e = length - 1;
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int len = arr.length;
		System.out.println("Original Array: " + Arrays.toString(arr));

		reverseIteratively(arr, len);
		System.out.println("Iterative Reverse: " + Arrays.toString(arr));
	}
}
```

- ## Recursive Approach

```java
import java.util.Arrays;

public class ReverseArray {
	public static void reverseRecursively(int arr[], int s, int e) {
		if (s >= e)
			return;
		int temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
		reverseRecursively(arr, ++s, --e);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int len = arr.length;
		System.out.println("Original Array: " + Arrays.toString(arr));

		reverseRecursively(arr, 0, len - 1);
		System.out.println("Recursive Reverse: " + Arrays.toString(arr));
	}
}
```
Reverse a List Array in Python
Lists and Arrays are similar in Python. Where the major difference among the two is that arrays only allow items of the same data type whereas lists allow them to be different.

Since Python doesn’t support conventional Arrays, we can use lists to depict the same and try to reverse them. Let us take a look at the different methods following which we can accomplish this task,


1. Using List Slicing to Reverse an Array in Python
We can reverse a list array using slicing methods. In this way, we actually create a new list in the reverse order as that of the original one. Let us see how:
```python
#The original array
arr = [11, 22, 33, 44, 55]
print("Array is :",arr)
 
res = arr[::-1] #reversing using list slicing
print("Resultant new reversed array:",res)
```
```python
Output:

Array is : [1, 2, 3, 4, 5]
Resultant new reversed array: [5, 4, 3, 2, 1]
```
2. Using reverse() Method
Python also provides a built-in method reverse() that directly reverses the order of list items right at the original place.

Note: In this way, we change the order of the actual list. Hence, the original order is lost.

```python
#The original array
arr = [11, 22, 33, 44, 55]
print("Before reversal Array is :",arr)
 
arr.reverse() #reversing using reverse()
print("After reversing Array:",arr)
```
```python
Output:

Before reversal Array is : [11, 22, 33, 44, 55]
After reversing Array: [55, 44, 33, 22, 11]
```
3. Using reversed() Method
We have yet another method, reversed() which when passed with a list returns an iterable having just items of the list in reverse order. If we use the list() method on this iterable object, we get a new list which contains our reversed array.
```python
#The original array
arr = [12, 34, 56, 78]
print("Original Array is :",arr)
#reversing using reversed()
result=list(reversed(arr))
print("Resultant new reversed Array:",result)
```
```python
Output:

Original Array is : [12, 34, 56, 78]
Resultant new reversed Array: [78, 56, 34, 12]
```
Reversing an Array of Array Module in Python
Even though Python doesn’t support arrays, we can use the Array module to create array-like objects of different data types. Though this module enforces a lot of restrictions when it comes to the array’s data type, it is widely used to work with array data structures in Python.

Now, let us see how we can reverse an array in Python created with the Array module.


4. Using reverse() Method
Similar to lists, the reverse() method can also be used to directly reverse an array in Python of the Array module. It reverses an array at its original location, hence doesn’t require extra space for storing the results.
```python
import array
 
#The original array
new_arr=array.array('i',[2,4,6,8,10,12])
print("Original Array is :",new_arr)
 
#reversing using reverse()
new_arr.reverse()
print("Reversed Array:",new_arr)
```
```python
Output:

Original Array is : array('i', [2, 4, 6, 8, 10, 12])
Resultant new reversed Array: array('i', [12, 10, 8, 6, 4, 2])
```
