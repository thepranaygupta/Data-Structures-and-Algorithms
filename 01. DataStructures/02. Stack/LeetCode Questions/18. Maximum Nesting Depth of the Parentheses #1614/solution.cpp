class Solution {
public:
    int maxDepth(string s) {
        stack<char> a;
        int count=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='('){
                a.push(s[i]);
                count++;
            }
            if(count>max){
                max=count;
            }
            if(s[i]==')'){
                a.pop();
                count--;
            }
        }
        return max;
    }
};
