package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 퇴사
public class DP_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int endDt = i+input[0]-1;
            if(endDt <= N){
                dp[endDt] = Math.max(dp[endDt], dp[i-1]+input[1]);
            }
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[N]);

        br.close();
    }
}
