/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.
Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        vector<string> curr;
        backtrack(s,curr,ans,0);
        return ans;
    }
    
    void backtrack(string s,vector<string>& curr,vector<vector<string>>& ans,int start){
        if(start==s.length()){
            ans.push_back(curr);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                curr.push_back(s.substr(start,i-start+1));
                backtrack(s,curr,ans,i+1);
                curr.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s,int start,int end){
        while(start<=end){
            if(s[start]!=s[end]) return false;
			start++; 
			end--;
        }
        return true;
    }
};
