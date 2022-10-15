package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 스티커
public class DP_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];
            int[][] dp = new int[n][3];
            sticker[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sticker[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            dp[0][1] = sticker[0][0];
            dp[0][2] = sticker[1][0];
            for(int i=1; i<n; i++){
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2])+sticker[0][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1])+sticker[1][i];
            }

            System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
        }

        br.close();
    }
}
