/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
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
