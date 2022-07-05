package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 나는 요리사다
public class Math1_2953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int winner = -1;
        for(int i=0; i<5; i++){
            int score = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();
            if(max < score){
                max = score;
                winner = i+1;
            }
        }

        System.out.println(winner+" "+max);

        sc.close();
    }
}
