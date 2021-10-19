class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long left=index;
        long right=n-index-1;
        long start=1;
        long end=maxSum;
        //Binary-Search in the range [1,maxSum] {start,end}
        while(start<=end)
        {
            long mid=start+(end-start)/2;
            long m=mid-1;
            long ls=0;
            long rs=0;
            //1+2+3+...+n = n*(n+1)/2 used formula:
            //If the value of "mid-1" >= (no of numbers we can put on "left").
            //Then.the total sum of "m" using (m*(m-1)/2) - "the values which don't appear" gives the left and right sum.
            if(m>=left)
            {
                long notInRange=m-left;
                ls=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            //Since.The value of m<left then that means the length of "left" is higher and some are left , those index are "left-m" *1 
            //Why 1? because value can't be 0 or <0.
            else
            {
                ls=m*(m+1)/2+1*(left-m);
            }
            if(m>=right)
            {
                long notInRange=m-right;
                rs=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else
            {
                rs=m*(m+1)/2+1*(right-m);
            }
            long sum=rs+ls+mid;
            //If the value of "sum > maxSum" then "values > mid" will also be >maxSum , hence reduce the range by decreasing the "end".
            if(sum>maxSum)
            {
                end=mid-1;
            }
            //If the value of "sum" <= "maxSum" then try to find the values <=maxSum by increasing the "start".
            else
            {
                start=mid+1;
            }
        }
        return (int)end;
    }
}