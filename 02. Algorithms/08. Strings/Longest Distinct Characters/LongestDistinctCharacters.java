/**
 * Question Link - https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
 */
public class LongestDistinctCharacters {

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        System.out.println(countLongestDistinct(input));
    }

    private static int countLongestDistinct(String str) {
        int curCount = 0;
        int maxCount = 0;

        for (int i = 0; i< str.length() - 1; i++){
            if (str.charAt(i) != str.charAt(i+1)){
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            }else {
                curCount = 0;
            }
        }

        return maxCount;
    }
}
