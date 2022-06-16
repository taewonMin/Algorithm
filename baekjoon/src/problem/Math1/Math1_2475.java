package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 검증수
public class Math1_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for(int i : input){
            sum += Math.pow(i, 2);
        }
        System.out.println(sum%10);

        sc.close();
    }
}
