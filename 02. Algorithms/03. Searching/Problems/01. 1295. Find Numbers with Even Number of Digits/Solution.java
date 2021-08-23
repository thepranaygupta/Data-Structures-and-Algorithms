class Solution {
    public int findNumbers(int[] arr) {
        int length = arr.length;
        int evencount = 0;
        for(int element: arr){
            int digitcount = 0;
            if(element < 0)
                element *= -1;
            while(element > 0){
                digitcount++;
                element /= 10;
            }
            if(digitcount%2 == 0)
                evencount++;
        }
        return evencount;
    }
}
