![Kth](https://user-images.githubusercontent.com/71629248/121235931-00059880-c8b3-11eb-91f4-96fcf6f1c0cc.jpg)

```java
   	public static int quickSort(int arr[],int l, int h, int k) {

		if(k>0 && k <= arr.length) {
			int pivotIndex=partition(arr,l,h);
			if(pivotIndex+1==k)
				return arr[pivotIndex];
			else if(pivotIndex+1>k) // this means kth smallest lies in left part
				return quickSort(arr,l,pivotIndex-1,k);
			else // this means kth smallest lies in right part
				return quickSort(arr,pivotIndex+1,h,k);
		}
		return Integer.MAX_VALUE;
	}
	
	private static int partition(int arr[],int l, int h) {
		// TODO Auto-generated method stub
		int pivot=arr[l];
		int i=l;
		int j=h;
		while(i<j) {
			while(i<=h && arr[i]<=pivot)i++;
			while(j>=l && arr[j]>pivot)j--;
			if(i<j) { // swap ith and jth
				swap(arr,i,j);
			}
		}
		// swap(j,l)
		swap(arr,j,l);
				
		return j;
	}
```
# **[See My Code Here](./KthSmallest.java)**
<hr>
<hr>
<hr>
<hr>

# Kth Smallest Element using PQ.
## My Approach :-
- We will make a MaxPQ of size K and initiallise it with 1st k elements.
- This PQ will store K smallest element always.
	- so we will itterate from k to last and add elements a[i] if it is less than pq.peek();
- and in last we will return pq.peek();
```java
int KthSmallestElement(int a[],int n,int k){
	PriorityQueue<Integer> maxPq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(i<k) 
                maxPq.add(a[i]);
            else{
               if(a[i]<maxPq.peek()){
                   maxPq.remove();
                   maxPq.add(a[i]);
               } 
            }
		}
		return pq.peek();
}
```
<hr>

# Kth Largest Element using PQ.
## My Approach :-
- We will make a MinPQ of size K and initiallise it with 1st k elements.
- This PQ will store K largest element always.
	- so we will itterate from k to last and add elements a[i] if it is more than pq.peek();
- and in last we will return pq.peek();
```java
class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Integer> minPq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            if(i<k) minPq.add(arr[i]);
            else{
                if(arr[i]>minPq.peek()){
                    minPq.remove();
                    minPq.add(arr[i]);
                }
            }
        }
        return minPq.remove();
    }
}
```
