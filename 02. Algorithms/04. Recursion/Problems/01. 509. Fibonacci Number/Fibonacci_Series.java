

import java.util.Scanner;

public class Fibonacci_Series {

    public static int fibRecursive(int n){

        if(n==0||n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter till which n you have to print fibonacci series");
        int n = s.nextInt();

        for(int i = 0;i<=n;i++){
            System.out.println(fibRecursive(i));
        }

    }
}
