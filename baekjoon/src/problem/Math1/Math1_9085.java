package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 더하기
public class Math1_9085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            sc.nextLine();
            int sum = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();
            System.out.println(sum);
        }

        sc.close();
    }
}