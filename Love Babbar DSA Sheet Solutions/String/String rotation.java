// article link- https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/ 


class StringRotation
{
	/* Function checks if passed strings (str1 and str2)
	are rotations of each other */
	static boolean areRotations(String str1, String str2)
	{
		// There lengths must be same and str2 must be
		// a substring of str1 concatenated with str1.
		return (str1.length() == str2.length()) &&
			((str1 + str1).indexOf(str2) != -1);
	}
	
	// Driver method
	public static void main (String[] args)
	{
		String str1 = "AACD";
		String str2 = "ACDA";

		if (areRotations(str1, str2))
			System.out.println("Strings are rotations of each other");
		else
			System.out.printf("Strings are not rotations of each other");
	}
}


//USING STL


import java.util.*;

class GFG{
static boolean check_rotation(String s, String goal)
{
	if (s.length() != goal.length())
		;
	Queue<Character> q1 = new LinkedList<>();
	for (int i = 0; i < s.length(); i++) {
		q1.add(s.charAt(i));
	}
	Queue<Character> q2 = new LinkedList<>();
	for (int i = 0; i < goal.length(); i++) {
		q2.add(goal.charAt(i));
	}
	int k = goal.length();
	while (k>0) {
		k--;
		char ch = q2.peek();
		q2.remove();
		q2.add(ch);
		if (q2.equals(q1))
			return true;
	}
	return false;
}
public static void main(String[] args)
{
	String s1 = "ABCD";
	String s2 = "CDAB";
	if (check_rotation(s1, s2))
		System.out.print(s2+ " is a rotated form of " + s1
			+"\n");
	else
		System.out.print(s2+ " is not a rotated form of " + s1
			+"\n");
	String s3 = "ACBD";
	if (check_rotation(s1, s3))
		System.out.print(s3+ " is a rotated form of " + s1
			+"\n");
	else
		System.out.print(s3+ " is not a rotated form of " + s1
			+"\n");
}
}

 //FOR MORE REFRER ABOVE LINK.



