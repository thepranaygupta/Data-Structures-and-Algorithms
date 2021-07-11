## **STEP 1 : [Complete this awesome playlist by CodingNinja.](https://youtube.com/playlist?list=PLGeDISzAH2BQ59_Cft8hC-HAGbwv8dgQu)**

## **STEP 2 : [Visualize my code here ](./MyHashMap.java)**

<br>

# **SET DS**

## The set interface present in the java.util package and extends the Collection interface is an unordered collection of objects in which duplicate values cannot be stored. It is an interface which implements the mathematical set. This interface contains the methods inherited from the Collection interface and adds a feature which restricts the insertion of the duplicate elements.

```java
public static void main(String[] args) {
		Set<Integer> st1=new HashSet<>();

		// 1. add()
			st1.add(3);
			st1.add(4);
			st1.add(2);
			st1.add(1);
			st1.add(3);
			st1.add(8);
			st1.add(-8);
			st1.add(-10);
		//2. printing of Set
			System.out.println(st1);// [1, 2, 3, 4, -8, 8, -10]
		//3. contains()
			System.out.println(st1.contains(3));// true
			System.out.println(st1.contains(7));// false
		//4. remove()
			System.out.println(st1.remove(-10));// true
			System.out.println(st1);// [1, 2, 3, 4, -8, 8]
		//5. iterating through the set
			for(int val:st1) {
				System.out.print(val+" ");// 1 2 3 4 -8 8
			}
			System.out.println();
//------------------Operating arrays with set-------------------
/**Way 1**/ Integer arr[]= {1, 9, 13, 42, -8, 8, -10};
			Set<Integer> st2=new HashSet<>(Arrays.asList(arr));
			System.out.println(st2);// [1, -8, 8, 9, -10, 42, 13]

/**Way 2**/ Set<Integer> st3=new HashSet<>(Arrays.asList(new Integer[] {100, 1, 3, 2, 4, 8, 9, 0}));
			System.out.println(st3);// [0, 1, 2, 3, 100, 4, 8, 9]

/**Way 3**/
			//6. addAll(collections)- This method is used to append all of the elements from the mentioned collection to the existing set.
			//The elements are added randomly without following any specific order. if at least one element is appended then return true else false.
			Set<Integer> st4=new HashSet<>();
			System.out.println(st4.addAll(Arrays.asList(arr)));// true
			System.out.println(st4.addAll(Arrays.asList(arr)));// false
			System.out.println(st4.addAll(Arrays.asList(new Integer[] {2, 9, 13, 42, -8, 8, -10})));// true coz, 2 is appended here
			System.out.println(st4);//[1, 2, -8, 8, 9, -10, 42, 13]

			//7. The removeAll(collection) method of java.util.Set interface is used to remove from this set all of its elements that are contained in the specified collection.
			//8. containsAll(collection) This method is used to check whether the set contains all the elements present in the given collection or not. This method returns true if the set contains all the elements and returns false if any of the elements are missing.
			//9. retainAll(collection) This method is used to retain all the elements from the set which are mentioned in the given collection. This method returns true if this set changed as a result of the call.
			//10. size() This method is used to get the size of the set. This returns an integer value which signifies the number of elements.


	}
```
