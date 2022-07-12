package problem.Math1;

import java.util.Scanner;

// 심부름 가는 길
public class Math1_5554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time = 0;
        for(int i=0; i<4; i++){
            time += sc.nextInt();
        }

        System.out.println(time/60);
        System.out.println(time%60);

        sc.close();
    }
}
