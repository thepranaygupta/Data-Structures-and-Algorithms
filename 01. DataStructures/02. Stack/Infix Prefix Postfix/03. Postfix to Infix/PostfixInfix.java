import java.util.*;

public class PostfixInfix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String postfix_exp="";
		System.out.println("Enter Postfix Expression");
		postfix_exp=sc.next();
		System.out.println("Equivalent infix Expression for "+postfix_exp+" is= "+PostfixToInfix(postfix_exp));
	}

	private static String PostfixToInfix(String postfix_exp) {
		Stack<String> st=new Stack();
		for(char ch:postfix_exp.toCharArray()) {
			if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z')) {
				st.push(Character.toString(ch));
			}
			else {
				String op2=st.pop();
				String op1=st.pop();
				String exp='('+op1+ch+op2+')';
				st.push(exp);
			}
		}

		return st.peek();
	}

}
