# Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo.

## **Input:** {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}

## **Output:** {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

# Approach 1: **Counting method** TC is O(2N) & SC is O(1)

- ## Make 3 variable named as count0, count1, count2 and store the count of 0's, 1's and 2's in each variable respectively.
- ## Now store 0 in index ranging from **0 to count0-1**
- ## Now store 1 in index ranging from **count0 to count1-1**
- ## Now store 2 in index ranging from **count1 to n-1**

# Approach 2: **Dutch National Flag Algorithm** TC is O(N) and SC is O(1)

DNF is usefull when you want to segregate less than three, fixed types of numbers. For e.g. segregate 0 1, segregate -ve +ve, segregate odd even and etc..

![dnf](https://user-images.githubusercontent.com/71629248/132945345-10b6a765-e043-4255-a997-e472ac1223bb.png)


```java
public static void main(String[] args) {
		int arr[]={0, 2, 1, 2, 0,1,2,0,2};
		int n=arr.length;

		 int i=0; int curr=0; int k=n-1;
	      while(curr<=k){
	          switch(arr[curr]){
	              case 0: swap(arr,i,curr);
	              		  curr++;
	              		  i++;
	              break;
	              case 1: curr++;
	              break;
	              case 2: swap(arr,k,curr);
	              		  k--;
	              break;
	          }
	      }
	      System.out.println(Arrays.toString(arr));
}
```


## **[Video Reference](https://youtu.be/oaVa-9wmpns)**
