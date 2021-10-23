/*Binary exponentiation (also known as exponentiation by squaring) is a trick which allows to calculate an using only O(logn) multiplications (instead of O(n) multiplications required by the naive approach).
It also has important applications in many tasks unrelated to arithmetic, since it can be used with any operations that have the property of associativity:
                                                                 (X⋅Y)⋅Z=X⋅(Y⋅Z)
Time Compexity : O(log n)
Algorithm:
Raising a to the power of n is expressed naively as multiplication by a done n−1 times: a^n=a.a.a...a. However, this approach is not practical for large a or n.
                    a^(b+c)=ab⋅ac and a^(2b)=a^b⋅a^b=(a^b)^2.
*/

//Implementation:
//Iterative way
long long binpow(long long a, long long b)
{
    long long ans = 1;
    while (b > 0)
    {
        if (b & 1)
            ans = ans * a;
        a = a * a;
        b >>= 1;
    }
    return ans;
}
//Recursive way:
long long binpow(long long a, long long b)
{
    if (b == 0)
        return 1;
    long long ans = binpow(a, b / 2);
    if (b % 2)
        return ans * ans * a;
    else
        return ans * ans;
}