package problem.Math1;

import java.util.Scanner;

// 만취한 상범
public class Math1_6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            boolean[] dp = new boolean[n+1];
            sc.nextLine();
            for(int j=1; j<=n; j++){
                for(int k=j; k<=n; k+=j){
                    dp[k] = !dp[k];
                }
            }

            int cnt = 0;
            for(boolean b : dp){
                if(b){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        sc.close();
    }
}
