class Solution {
    public List<List<Integer>> twoSum(int[] arr, int target, int si, int ei) {
        List<List<Integer>> ans = new ArrayList<>();
        while(si < ei) {
            int sum = arr[si] + arr[ei];
            if(sum == target) {
                ArrayList<Integer> smallAns = new ArrayList<>();
                smallAns.add(arr[si]);
                smallAns.add(arr[ei]);
                ans.add(smallAns);
                si++;
                ei--;
                while(si < ei && arr[si] == arr[si - 1])
                    si++;
                while(si < ei && arr[ei] == arr[ei + 1])
                    ei--;
            } else if (sum < target) 
                si++;
            else 
                ei--;
        }

        return ans;
    }

    public void prepareAns(List<List<Integer>> ans, List<List<Integer>> smallAns, int fixEle) {
        for(List<Integer> arr : smallAns) {
            List<Integer> ar = new ArrayList<>();
            ar.add(fixEle);
            for(int ele : arr)
                ar.add(ele);
            ans.add(ar);
        }
    }
    
    public List<List<Integer>> kSum(int[] arr, int target, int k, int si, int ei) {
        if (k == 2) {
            return twoSum(arr, target, si, ei);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = si; i < ei;) {
            List<List<Integer>> smallAns = kSum(arr, target - arr[i], k - 1, i + 1, ei);
            prepareAns(ans, smallAns, arr[i]);
            i++;
            while (i < ei && arr[i] == arr[i - 1]) 
                i++;
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = kSum(arr, target, 4, 0, n - 1);

        return ans;
    }
}
