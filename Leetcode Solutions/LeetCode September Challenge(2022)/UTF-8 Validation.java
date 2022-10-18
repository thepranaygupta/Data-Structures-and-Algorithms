public class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length; i ++) {
            int count = getBytesNum(data[i]);
            if(count == -1) return false;
            while(count > 1) {
                i ++;
                count --;
                if(i < data.length && (data[i] & 192) == 128) continue;
                else return false;
            }
        }
        return true;
    }
    public int getBytesNum(int num) {
        int move = 7;
        while(move >= 0 && ((num >> move) & 1) == 1) move --;
        int count = 7 - move;
        if(count == 1 || count > 4) return -1;
        return count;
    }
}