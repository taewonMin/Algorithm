package problem.Dp;

import java.util.Scanner;

// 쉬운 계단 수
public class DP_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];  // N번째 자리가 0~9로 끝나는 계단수 개수ㅎ
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1];
                }else if(j==9){
                    dp[i][j] = dp[i-1][8];
                }else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }

        int sum = 0;
        for(int i : dp[N]){
            sum = (sum+i)%1000000000;
        }
        System.out.println(sum);

        sc.close();
    }
}
