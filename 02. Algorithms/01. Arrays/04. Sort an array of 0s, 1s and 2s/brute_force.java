class Solution
{
    public static void sort012(int a[], int n)
    {
        int c0 = 0, c1 = 0, c2 = 0;
        for(int ele: a)
        {
            if(ele == 0)
                c0++;
            else if(ele == 1)
                c1++;
            else
                c2++;
        }
        int index = 0;
        for(; index < c0; index++)
            a[index] = 0;
        for(; index < c0+c1; index++)
            a[index] = 1;
        for(; index < c0+c1+c2; index++)
            a[index] = 2;
    }
}
