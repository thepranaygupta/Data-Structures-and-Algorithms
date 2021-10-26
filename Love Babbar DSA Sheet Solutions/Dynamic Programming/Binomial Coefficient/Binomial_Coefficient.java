/*
  This is the standard Formula to calculate BinomialCoffecient
   C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1
 
 */
import java.util.*;
public class Main {

	//Calculation of BinomialCoffecient through Recursion
	private int bcRecursive(int n,int k) {
		if(k>n) return 0;
		if(k==0 || k==n) return 1;
		return bcRecursive(n-1,k-1)+bcRecursive(n-1,k);
	}

	//Calculation of BinomialCoffecient through bottom Up Dynamic Programming
	private int binomialCoffecient(int n,int k) {
		int[][] dp = new int[n+1][k+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i,k);j++) {
				if(j==0 || j==i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
		return dp[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Main ob = new Main();
		System.out.println(ob.binomialCoffecient(n, k)+"  "+ob.bcRecursive(n, k));

	}

}
