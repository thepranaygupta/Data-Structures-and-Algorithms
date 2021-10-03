

int binsearch(int A[], int low, int high, int key){
    
    if (low<=high){
        int mid = low + (high-low)/2;

        if(key== A[mid]){
            return mid;
        }
        
        else if (key<A[mid]){
            return binsearch(A, low, mid-1, key);
        }
        
        else
        {
            return binsearch(A, low, mid+1, key);
        }
    }
    return -1;
}
