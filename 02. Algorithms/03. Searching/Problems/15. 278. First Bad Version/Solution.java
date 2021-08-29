// https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(isBadVersion(mid) == false)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
