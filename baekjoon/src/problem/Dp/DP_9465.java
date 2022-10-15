package problem.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 스티커
public class DP_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            dp[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
            for(int i=2; i<n; i++){
                dp[0][i] += Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] += Math.max(dp[0][i-1], dp[0][i-2]);
            }

            bw.write(Math.max(dp[0][n-1], dp[1][n-1])+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
