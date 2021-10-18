import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,2};

        // Before Sorting
        System.out.println(Arrays.toString(arr));

        // Sort Function
        sort(arr, arr.length);

        // After Sorting
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int n) {
        if (n==1) return;

        for(int i=0; i<n-1; i++){
            if (arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        sort(arr, n-1);
    }
}
