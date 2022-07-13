package problem.Recursion;

import java.util.Scanner;

// 곱셈
public class Recursion_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(recursion(A, B, C));

        sc.close();
    }

    public static long recursion(long A, long B, long C){
        if(B==1){
            return A%C;
        }
        long val = recursion(A,B/2,C);
        val = val*val%C;

        if(B%2==1){
            return A*val % C;
        }else{
            return val;
        }
        
    }
}
