import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = s.nextLine();
        System.out.println(Vowels(str));

    }

    public static boolean Vowels(String str) {

        List<Character> vowels = new ArrayList<Character>(List.of('a','e','i','o','u'));
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}