package problem.Implement;

import java.util.Scanner;

// 별 찍기 - 5
public class Imple_2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<N-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
