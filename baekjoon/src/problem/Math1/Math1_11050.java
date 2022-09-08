package problem.Math1;

import java.util.Scanner;

// 이항 계수 1
public class Math1_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 1;
        for(int i=2; i<=N; i++){
            result *= i;
        }
        for(int i=2; i<=N-M; i++){
            result /= i;
        }
        for(int i=2; i<=M; i++){
            result /= i;
        }
        System.out.println(result);

        sc.close();
    }
}
