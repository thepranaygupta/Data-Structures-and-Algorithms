### Problem Link: https://www.geeksforgeeks.org/majority-element/

- ## Approach 1:

```java
import java.io.*;
 
class GFG {
 
    // Function to find Majority element
    // in an array
    static void findMajority(int arr[], int n)
    {
        int maxCount = 0;
        int index = -1; // sentinels
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
 
            // update maxCount if count of
            // current element is greater
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
 
        // if maxCount is greater than n/2
        // return the corresponding element
        if (maxCount > n / 2)
            System.out.println(arr[index]);
 
        else
            System.out.println("No Majority Element");
    }
 
    // Driver code
    public static void main(String[] args)
    {
 
        int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
        int n = arr.length;
 
        // Function calling
        findMajority(arr, n);
    }
    // This code is contributed by ajit.
}
```
- ## Approach 2 (Using Binary Search Tree)
  
```java
import java.io.*;
 
class Node
{
    int key;
    int c = 0;
    Node left,right;
     
}
class GFG{
     
static int ma = 0;
 
// A utility function to create a
// new BST node
static Node newNode(int item)
{
    Node temp = new Node();
    temp.key = item;
    temp.c = 1;
    temp.left = temp.right = null;
    return temp;
}
 
// A utility function to insert a new node
// with given key in BST
static Node insert(Node node, int key)
{
     
    // If the tree is empty,
    // return a new node
    if (node == null)
    {
        if (ma == 0)
            ma = 1;
 
        return newNode(key);
    }
     
    // Otherwise, recur down the tree
    if (key < node.key)
        node.left = insert(node.left, key);
    else if (key > node.key)
        node.right = insert(node.right, key);
    else
        node.c++;
 
    // Find the max count
    ma = Math.max(ma, node.c);
  
    // Return the (unchanged) node pointer
    return node;
}
 
// A utility function to do inorder
// traversal of BST
static void inorder(Node root, int s)
{
    if (root != null)
    {
        inorder(root.left, s);
 
        if (root.c > (s / 2))
            System.out.println(root.key + "\n");
 
        inorder(root.right, s);
    }
}
 
// Driver Code
public static void main(String[] args)
{
    int a[] = { 1, 3, 3, 3, 2 };
    int size = a.length;
    Node root = null;
     
    for(int i = 0; i < size; i++)
    {
        root = insert(root, a[i]);
    }
     
    // Function call
    if (ma > (size / 2))
        inorder(root, size);
    else
        System.out.println("No majority element\n");
}
  
```

- ## Approach 3 (Using Moore’s Voting Algorithm)

```java
class MajorityElement {
    /* Function to print Majority Element */
    void printMajority(int a[], int size)
    {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);
 
        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }
 
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
 
    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }
 
    /* Driver code */
    public static void main(String[] args)
    {
        MajorityElement majorelement
            = new MajorityElement();
        int a[] = new int[] { 1, 3, 3, 1, 2 };
       
        // Function call
        int size = a.length;
        majorelement.printMajority(a, size);
    }
}
