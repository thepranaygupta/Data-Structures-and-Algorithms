import java.util.Arrays;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int st[]=new int[nums1.length];
        int top=-1;
        for(int ele: nums1){
            int index=getIndex(nums2,ele);
            if(index==nums2.length-1){
                top++;
                st[top]=-1;
                continue;
            }
            int indexG=getIndexG(nums2,ele,index+1,nums2.length);
            if(indexG!=-1){
                top++;
                st[top]=nums2[indexG];
            }
            else{
                top++;
                st[top]=-1;
            }
        }
        return st;
    }
    
    public int getIndex(int nums2[],int key){
        int i=0;
        for(i=0;i<nums2.length;i++){
            if(nums2[i]==key){
                break;
            }
        }
        return i;
    }
    
    public int getIndexG(int nums2[],int key,int s,int e){
        int i=s;
        int f=0;
        for(i=s;i<e;i++){
            if(nums2[i]>key){
                f=1;
                break;
            }
        }
        if(f==1)
            return i;
        else 
            return -1;
    }
}