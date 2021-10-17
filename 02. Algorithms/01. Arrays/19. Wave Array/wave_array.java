import java.util.*;
public class waveform {
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int t = 0;
        for (int i = 0; i < n; i += 2) 
        {
            t = 0;
            if (i > 0 && arr[i - 1] > arr[i]) 
            {
                t = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = t;
            }
            if (i < n - 1 && arr[i] < arr[i + 1]) 
            {
                t = 0;
                t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
