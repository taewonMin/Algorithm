package problem.Math1;

import java.util.Scanner;

// 새
public class Math1_1568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int time = 0;
        int k = 1;
        while(N>0){
            if(k > N){
                k = 1;
            }else{
                N -= k;
                k++;
                time++;
            }
        }

        System.out.println(time);

        sc.close();
    }
}
