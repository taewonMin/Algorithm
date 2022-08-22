package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

public class Math1_11948{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[4];
        for(int i=0; i<4; i++){
            scores[i] = sc.nextInt();
            sc.nextLine();
        }
        Arrays.sort(scores);
        
        int sum = 0;
        for(int i=1; i<4; i++){
            sum += scores[i];
        }

        int max = 0;
        for(int i=0; i<2; i++){
            max = Math.max(max, sc.nextInt());
            sc.nextLine();
        }

        System.out.println(sum+max);

        sc.close();
    }
}