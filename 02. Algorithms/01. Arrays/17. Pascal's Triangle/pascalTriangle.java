import java.util.*;
public class PascalTriangel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        System.out.println(generateTriangel(numRows));
    }

    // method for Pascal's Triangel generation using ArrayList as auxiliary space and nested for loop
    public static List<List<Integer>> generateTriangel(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int line=1;line<=numRows;line++){
            int c = 1;
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i =1;i<=line;i++){
                ans.add(c);
                c = c*(line-i)/i;
            }
            res.add(ans);
        }
        return res;
    }
}
