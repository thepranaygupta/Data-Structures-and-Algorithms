import java.util.*;
public class InfixPostfix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String infix_exp="";
		System.out.println("Enter Infix Expression");
		infix_exp=sc.next();
		System.out.println("Equivalent postfix Expression for "+infix_exp+" is= "+InfixToPostfix(infix_exp));
	}

	private static String InfixToPostfix(String infix_exp) {
		String postfix="";
		Stack<Character> st=new Stack();
		for(char ch:infix_exp.toCharArray()) {
			
			//character is operend.
			if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z'))
					postfix+=ch;
			//character is opening bracket
			else if(ch=='('){
				st.push(ch);		
			}
			//character is closing bracket
			else if(ch==')') {
				while(!st.isEmpty()&& st.peek()!='(') {
					postfix+=st.pop();
				}
				if(st.peek()=='(')
				{
					st.pop();
				}
			}
			//else character will be operator
			else {
				if(st.isEmpty()) 
					st.push(ch);
				else {
					if( pre(ch) > pre(st.peek()) ) {
						st.push(ch);
					}
					else if( (pre(ch) == pre(st.peek()) ) && (ch=='^'))
					{
						st.push(ch);
					}
					else {
						while( (!st.isEmpty()) && (pre(ch)<=pre(st.peek())) )
						{
							postfix+=st.pop();
							
						}
						st.push(ch);
					}
					
				}
			}
					
		}
		while(!st.isEmpty())
		{
			postfix+=st.pop();
		}
		
		return postfix;
		
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
