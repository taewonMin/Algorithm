package problem.Implement;

import java.util.Arrays;
import java.util.Scanner;

// 와글와글 숭고한
public class Imple_17388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] univ = new String[]{"Soongsil", "Korea", "Hanyang"};

        int[] input = new int[3];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0; i<3; i++){
            input[i] = sc.nextInt();
            sum += input[i];
            if(min > input[i]){
                min = input[i];
                minIdx = i;
            }
        }
        if(sum >= 100){
            System.out.println("OK");
        }else{
            System.out.println(univ[minIdx]);
        }

        sc.close();
    }
}
