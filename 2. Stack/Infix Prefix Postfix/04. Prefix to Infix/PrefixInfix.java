import java.util.*;
public class PrefixInfix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String prefix_exp="";
		System.out.println("Enter Prefix Expression");
		prefix_exp=sc.next();
		System.out.println("Equivalent infix Expression for "+prefix_exp+" is= "+PrefixToInfix(prefix_exp));

	}

	private static String PrefixToInfix(String prefix_exp) {
		Stack<String> st=new Stack();
		for(int i=prefix_exp.length()-1;i>=0;i--) {
			char ch=prefix_exp.charAt(i);
			if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z')) {
				st.push(Character.toString(ch));
			}
			else {
				String op1=st.pop();
				String op2=st.pop();
				String exp='('+op1+ch+op2+')';
				st.push(exp);
			}
		}

		return st.peek();
	}

}
