package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 과자
public class Math1_10156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = input[0] * input[1] - input[2];

        if(result > 0){
            System.out.println(result);
        }else{
            System.out.println(0);
        }

        sc.close();
    }
}
