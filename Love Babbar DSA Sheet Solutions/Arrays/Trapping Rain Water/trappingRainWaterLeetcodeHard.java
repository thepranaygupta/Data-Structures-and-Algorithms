import java.util.*;
import java.io.*;
import java.lang.*;
public class solution{
int traprain(int arr[])
{
  int n=arr.length;
  int right[]=new int[n];
  int left[]=new int[n];
  left[0]=arr[0];
  for(int i=1;i<n;i++)
  {
  left[i]=Math.max(left[i-1],arr[i]);
  }
  right[n-1]=arr[n-1];
  for(int i=n-2;i>=0;i--)
  {
    right[i]=Math.max(right[i+1],arr[i]);
  }
  int res=0;
  for(int i=0;i<n;i++)
  {
    res+=(Math.min(left[i],right[i])-arr[i]);
  }
  return res;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++)
{
  arr[i]=sc.nextInt();
}
int u=traprain(arr);
System.out.println(u);
}
}
