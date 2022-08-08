package problem.Math1;

import java.util.Scanner;

// 만취한 상범
public class Math1_6359 {
    public static void main(String[] args) {
        // sol1();
        sol2();
    }

    // DP
    public static void sol1(){
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
            for(int j=1; j<=n; j++){
                if(dp[j]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        sc.close();
    }

    // 제곱수
    public static void sol2(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            sc.nextLine();

            System.out.println((int)Math.sqrt(n));
        }

        sc.close();
    }
}
