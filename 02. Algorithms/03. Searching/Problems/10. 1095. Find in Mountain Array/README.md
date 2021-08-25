## 1095. Find in Mountain Array

## https://leetcode.com/problems/find-in-mountain-array/

1. First find the peak index in the mountain array.
2. Search in the first half (asc order) and if not found then second half.
3. Use Order Agnostic Binary Search to search the target. 

```java
class Solution {
	public int findInMountainArray(int target, MountainArray A) {

		int peak = peakOfMountainArray(A);
		int firstTry = orderAgnosticBinarySearch(A, target, 0, peak);
		if (firstTry != -1) {
			return firstTry;
		}
		return orderAgnosticBinarySearch(A, target, peak + 1, A.length() - 1);
	}

	int peakOfMountainArray(MountainArray A) {
		int start = 0;
		int end = A.length() - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (A.get(mid) > A.get(mid + 1)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	int orderAgnosticBinarySearch(MountainArray A, int target, int start, int end) {
		boolean isAsc = A.get(start) < A.get(end);

		while (start <= end) {

			int mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				return mid;
			}

			if (isAsc) {
				if (A.get(mid) > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (A.get(mid) < target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}
```
