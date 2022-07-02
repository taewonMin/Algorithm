package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 지능형 기차
public class Math1_2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int people = 0;
        for(int i=0; i<4; i++){
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            people -= input[0];
            people += input[1];
            if(max < people){
                max = people;
            }
        }

        System.out.println(max);

        sc.close();
    }
}
