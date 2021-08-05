import java.util.*;
public class InfixPrefix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String infix_exp="";
		System.out.println("Enter Infix Expression");
		infix_exp=sc.next();
		System.out.println("Equivalent prefix Expression for "+infix_exp+" is= "+InfixToPrefix(infix_exp));

	}

	private static String InfixToPrefix(String infix_exp) {
		infix_exp=reverse(infix_exp);
		infix_exp=swapBrac(infix_exp);
		
		
		String prefix="";
		Stack<Character> st=new Stack();
		for(char ch:infix_exp.toCharArray()) {
			
			//character is operend.
			if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z'))
					prefix+=ch;
			//character is opening bracket
			else if(ch=='('){
				st.push(ch);		
			}
			//character is closing bracket
			else if(ch==')') {
				while(!st.isEmpty()&& st.peek()!='(') {
					prefix+=st.pop();
				}
				if(st.peek()=='(')
				{
					st.pop();
				}
			}
			//character is operator
			else {
				if(st.isEmpty())
					st.push(ch);
				else {
					if( pre(ch) > pre(st.peek()) ) {
						st.push(ch);
					}
					else if(pre(ch)==pre(st.peek()) && ch=='^') {
						while(pre(ch)==pre(st.peek()) && ch=='^') {
							prefix+=st.pop();
						}
						st.push(ch);
					}
					else if( pre(ch)<pre(st.peek()) ) {
						while( (!st.isEmpty()) && (pre(ch)<pre(st.peek())) )
						{
							prefix+=st.pop();
							
						}
						st.push(ch);
					}
					else if(pre(ch)==pre(st.peek())) {
						st.push(ch);
					}
				}
			}
		}
		while(!st.isEmpty())
		{
			prefix+=st.pop();
		}

		return reverse(prefix);
	}

	private static String swapBrac(String infix_exp) {
		char arr[]=infix_exp.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(')
				arr[i]=')';
			else if(arr[i]==')')
				arr[i]='(';
		}
		
		return String.valueOf(arr);
	}

	private static String reverse(String infix_exp) {
		StringBuilder str=new StringBuilder(infix_exp);  
	    str.reverse();  
	    return str.toString();  
	}
	
	public static int pre(char c) 
	{ 
	    if(c == '^') 
	    return 3; 
	    else if(c == '*' || c == '/') 
	    return 2; 
	    else if(c == '+' || c == '-') 
	    return 1; 
	    else
	    return -1; 
	} 

}
