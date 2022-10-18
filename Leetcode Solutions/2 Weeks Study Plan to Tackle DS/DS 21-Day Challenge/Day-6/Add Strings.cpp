class Solution {
public:
    string addStrings(string num1, string num2) {
        string f = "";
        int n1= num1.size(), n2=num2.size();
        while(n1<n2){num1 = "0"+num1;n1+=1;}
        while(n2<n1){num2 = "0"+num2;n2+=1;}
        int carry = 0;
        for(int i=n1-1;i>=0;--i){
            int c1 = num1[i]-'0', c2 = num2[i]-'0';
            int s = carry+c1+c2;
            if(i==0){
                string ss = to_string(s);
                f = ss+f;
                break;
            }
            f = to_string(s%10)+f;
            carry = s/10;
        }
        return f;
    }
};