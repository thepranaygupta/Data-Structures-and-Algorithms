//  link- https://leetcode.com/problems/reverse-words-in-a-string/

// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
// Example 4:

// Input: s = "  Bob    Loves  Alice   "
// Output: "Alice Loves Bob"


class Solution {
public:
   string reverseWords(string A) {   
reverse(A.begin(),A.end()); //reverse the original string
stringstream w(A);  //w comprises of all reversed words of A 
string word;
string rev_word="";  //final string to be returned

while(w>>word)
{
    reverse(word.begin(),word.end());  //reversing the word so that it comes to original form
    rev_word += word; //storing word
    rev_word += " ";     //adding space
}

rev_word.erase(rev_word.length()-1,1); //removing the additional last space added 
return rev_word; 
}
};