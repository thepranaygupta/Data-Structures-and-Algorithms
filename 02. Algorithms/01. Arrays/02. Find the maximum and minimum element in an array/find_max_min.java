import java.util.Scanner;

public class find_max_min {
    
    public static int[] create(){
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0 ; i<n;i++){
            System.out.println("Enter the number");
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static int max(int arr[]){
        int max = arr[0];
        for(int i : arr){
            if(i>max){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int arr[] = create();
        int max = max(arr);
        System.out.println(max);
    }
}
