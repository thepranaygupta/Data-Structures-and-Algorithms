class Solution {
public:
    int concatenatedBinary(int n) {
        long res = 0, mod = 1e9+7, len_of_curr = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i-1)) == 0)
                len_of_curr++;
            res = (res << len_of_curr) % mod;
            res += i % mod;
        }
        return res;
    }
};