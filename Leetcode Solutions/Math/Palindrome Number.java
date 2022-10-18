class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, temp = x;
        if(x >=0 && x<=9){
            return true;
        }
        else if(x > 9){
            while(x != 0){
                rev = (rev * 10) + (x %10);
                x = x /10;
            }
            if(rev == temp){
                return true;
            }
        
        }
        return false;
        
    }
}
