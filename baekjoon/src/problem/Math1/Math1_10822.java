package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 더하기
public class Math1_10822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        sc.close();
    }
}
