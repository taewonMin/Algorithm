package problem.Implement;

import java.util.Scanner;

// 별 찍기 - 8
public class Imple_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i=N; i>0; i--){
            int cnt = N-i+1;
            for(int j=0; j<cnt; j++){
                System.out.print("*");
            }
            for(int j=0; j<2*(N-cnt); j++){
                System.out.print(" ");
            }
            for(int j=0; j<cnt; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1; i<N; i++){
            int cnt = N-i;
            for(int j=0; j<cnt; j++){
                System.out.print("*");
            }
            for(int j=0; j<2*i; j++){
                System.out.print(" ");    
            }
            for(int j=0; j<cnt; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
