package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사 2
public class DP_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];    // dp[n] : n일차에 얻을 수 있는 최대 수익

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int endDt = i+t-1;
            if(endDt <= N){
                dp[endDt] = Math.max(dp[endDt], dp[i-1]+p);
            }
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[N]);

        br.close();
    }
}
