package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카드 구매하기
public class DP_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] card = new int[N+1];
        String[] input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            card[i] = Integer.parseInt(input[i-1]);
        }
        
        dp[1] = card[1];
        for(int i=2; i<=N; i++){
            dp[i] = card[i];
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+card[j]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}
