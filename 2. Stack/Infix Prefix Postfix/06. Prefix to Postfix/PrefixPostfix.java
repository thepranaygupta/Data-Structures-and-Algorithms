import java.util.*;

public class PrefixPostfix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String prefix_exp="";
		System.out.println("Enter prefix Expression");
		prefix_exp=sc.next();
		System.out.println("Equivalent postfix Expression for "+prefix_exp+" is= "+PrefixToPostfix(prefix_exp));

	}

	private static String PrefixToPostfix(String prefix_exp) {
		Stack<String> st=new Stack();
		
		for(int i=prefix_exp.length()-1;i>=0;i--) {
			char ch=prefix_exp.charAt(i);
			if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z')) {
				st.push(Character.toString(ch));
			}
			else {
				String op1=st.pop();
				String op2=st.pop();
				String exp=op1+op2+ch;
				st.push(exp);
			}
		}

		return st.peek();
	}

}
