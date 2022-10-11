public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ca = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(ct);
        String ss = new String(ca);
        String st = new String(ct);
        return ss.equals(st);
    }
}