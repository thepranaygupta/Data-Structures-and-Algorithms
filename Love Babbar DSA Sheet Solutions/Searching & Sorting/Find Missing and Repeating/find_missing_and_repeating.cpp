//Problem Statement : 
/*   
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
*/

//Function to solve the problem
int *findTwoElement(int *arr, int n) {
        int *ans = new int[2];
        unordered_map<int, int> mp;
        for(int i = 0; i < n; i++)
            mp[arr[i]]++ ;
        
        
        for(int i = 1; i < n + 1; i++)
            if(mp[arr[i]] > 1)
                ans[0] = arr[i];
                // m n  
        for(int i = 1; i <= n; i++)
            if(mp[i] == 0){
                ans[1] = i;
                break;
            }
            
        return ans;    
    }
