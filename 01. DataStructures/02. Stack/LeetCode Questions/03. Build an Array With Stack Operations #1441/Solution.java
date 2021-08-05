class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> arr = new ArrayList<String>();
        int input = 1; //1,2,3,4,....,n
        for(int i=0; i<target.length; i++) {
            while(input<target[i]) {
                arr.add("Push");
                arr.add("Pop");
                input++;
            }
            arr.add("Push");
            input++;
        }
        return arr;
    }
}
