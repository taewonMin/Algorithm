package problem.Math1;

import java.util.Scanner;

// 소인수분해
public class Math1_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        for(int i=2; i<=Math.sqrt(N); i++){
            while(N%i==0){
                sb.append(i+"\n");
                N /= i;
            }
        }

        if(N!=1){
            sb.append(N+"\n");
        }

        System.out.print(sb);

        sc.close();
    }
}
