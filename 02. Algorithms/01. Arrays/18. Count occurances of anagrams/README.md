## 18.Count occurances of anagrams
## https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

Count Occurences of Anagrams 

Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.

```C++
#define max 256
class Solution{
public:
	bool compare(char count[],char countW[])
{
    for(int i=0;i<max;i++){
        if(count[i]!=countW[i])
        return false;
    }
    return true;
}
	int search(string pat, string txt) {
	    // code here
	    int M = pat.size();
	    int N = txt.size();
	    char count[max]={0};
	    char countW[max]={0};
	    for(int i=0;i<M;i++){
	        countW[pat[i]]++;
	        count[txt[i]]++;
	    }
	    int x = 0;
	    for(int i=M;i<N;i++){
	        if(compare(count,countW))
	        x++;
	        
	        count[txt[i]]++;
	        count[txt[i-M]]--;
	    }
	     if (compare(count, countW))
           x++;
	    return x;
	}

};
```

## Expected Time Complexity: O(N)
## Expected Auxiliary Space: O(26) or O(256)
