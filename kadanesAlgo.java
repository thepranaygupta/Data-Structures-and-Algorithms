int maxsumarr(int arr[])
{
int max=0;
int curr=0;
for(int i=0;i<arr.length;i++)
{
  curr=curr+arr[i];
  if(curr>max)
    max=curr;
  if(curr<0)
    curr=0;
}
return max;
}
