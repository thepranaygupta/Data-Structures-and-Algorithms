import java.util.HashSet;
import java.util.Set;

/**
 * Question Link - https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "abrakadabra";
        System.out.println(firstNonRepeatingChar(input));
    }

    private static Character firstNonRepeatingChar(String str) {
        Set<Character> charSet = new HashSet<>();
        Character nonRepCh = null;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!charSet.contains(ch)) {
                nonRepCh = ch;
            }
            charSet.add(ch);
        }
        return nonRepCh;

    }
}
