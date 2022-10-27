public class QuickSort {
    
    public static int sort(int arr[],int si,int ei){

        int p = arr[si];
        int c = 0;
        for(int i = si;i<ei;i++){
            if(p>arr[i]){
                c++;
            }
        }
        int t = arr[c+si];
        arr[c+si] = p;
        arr[si] = t;

        int i = si;
        int j = ei-1;

        while (i<j){

            if(arr[i]<p){
                i++;
            } else if (arr[j]>=p) {
             j--;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return si+c;
    }

    public static void quick(int arr[],int si,int ei){

        if(si>=ei){
            return;
        }

        int p = sort(arr,si,ei);
        sort(arr,si,p-1);
        sort(arr,p+1,ei);

    }

    public static void main(String[] args) {

        int arr[] = {2,1,9,6,3};

       quick(arr,0, arr.length);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
