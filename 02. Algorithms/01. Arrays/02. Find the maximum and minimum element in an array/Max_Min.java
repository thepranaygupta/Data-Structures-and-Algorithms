import java.util.*;
class Max_Min
{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       int n,i,a[],max,min;
       System.out.print("Enter size of array = ");
       n=sc.nextInt();
       a=new int[n];
       System.out.println("Enter elements");
       for(i=0;i<n;i++)
       a[i]=sc.nextInt();
       max=a[0];
       min=a[0];
       for(i=0;i<n;i++)
       {
           if(a[i]>max)
           max=a[i];
           if(a[i]<min)
           min=a[i];
       }
       System.out.println("Maximum element = "+max);
       System.out.println("Minimum element = "+min);
    }
}
