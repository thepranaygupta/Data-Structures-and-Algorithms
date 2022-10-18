class Solution {
public:
    string add(string s1, string s2) {
        unsigned char carry = 0;
        unsigned char n1, n2;
        unsigned char sum = 0;
        string res = "";
        int ldiff = s1.length() - s2.length();
        int i1 = s1.length() - 1;
        for (int i = i1; i >= 0; i--) {
            int i2 = i - ldiff;
            n1 = s1[i] - '0';
            if (i2 >= 0) {
                n2 = s2[i2] - '0';
                sum = n1 + n2 + carry;
                carry = sum / 10;
                res += (sum % 10) + '0';
            }
            else {
                sum = n1 + carry;
                carry = sum / 10;
                res += (sum % 10) + '0';
            }
        }
        if (sum >= 10) {
            res += (sum / 10) + '0';
        }
        return res;
    }
    string addStrings(string num1, string num2) {
        string res = "";
        string ret = "";
        if (num1.length() > num2.length()) 
            res = add(num1, num2);
        else
            res = add(num2, num1);
        for (int i = res.length() - 1; i >= 0; i--)
        {
            ret += res[i];
        }
        return ret;
    }
};