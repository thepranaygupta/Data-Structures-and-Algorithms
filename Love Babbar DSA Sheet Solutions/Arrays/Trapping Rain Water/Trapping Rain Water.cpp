//Solution

#include<algorithm>
class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        for( int i = 0; i < height.size(); i ++ )
        {
            int h = height[i];
            if ( h != 0 )
            {
                if ( (i + 1) < height.size() && height[ i + 1 ] >= h )
                    continue;
                int end = 0;
                int flag = 0;
                int max = 0;
                for ( int j = i + 2; j < height.size(); j ++ )
                {
                    if ( height[j] >= h )
                    {
                        end = j;
                        max = height[j];
                        flag = 2;
                        break;
                    }
                    if ( height[j] > max )
                    {
                        end = j;
                        max = height[j];
                        flag = 1;
                    }
                }

                if ( flag == 0 )
                    continue;
                int effh = min( h, max);
                for( int k = i + 1; k < end; k ++ )
                {
                    if ( effh <= height[k] )
                        continue;
                    water += (effh - height[k]);
                }
                i = end - 1;
            }
        }
        return water;
    }
};
