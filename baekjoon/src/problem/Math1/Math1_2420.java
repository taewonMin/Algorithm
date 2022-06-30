package problem.Math1;

import java.util.Scanner;

// 사파리월드
public class Math1_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long M = sc.nextInt();
        System.out.println(Math.abs(N - M));

        sc.close();
    }
}
