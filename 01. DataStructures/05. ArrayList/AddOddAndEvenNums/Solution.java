import java.util.ArrayList;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            if(A[i]%2==0)
                evens.add(A[i]);
            else
                odds.add(A[i]);
        }
        int index = 0;
        for(Integer val: evens){
            A[index] = val;
            index += 2;
        }
        index = 1;
        for(Integer val: odds){
            A[index] = val;
            index += 2;
        }
        return A;
    }
}