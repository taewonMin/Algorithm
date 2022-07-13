package problem.Recursion;

import java.util.Scanner;

// Z
public class Recursion_1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(recursion(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        sc.close();
    }

    public static int recursion(int n, int r, int c){
        if(n==0){
            return 0;
        }

        int half = (int) Math.pow(2, n-1);
        if(r < half && c < half){   // 왼쪽위
            return recursion(n-1, r, c);
        }else if(r < half && c >= half){    // 오른쪽위
            return half*half + recursion(n-1,r,c-half);
        }else if(r >= half && c < half){    // 왼쪽아래
            return 2*half*half + recursion(n-1, r-half, c);
        }else{
            return 3*half*half + recursion(n-1, r-half, c-half);
        }
    }
}
