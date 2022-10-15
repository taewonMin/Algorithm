package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 극장 좌석
public class DP_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] vip = new boolean[N+1];
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=0; i<M; i++){
            vip[Integer.parseInt(br.readLine())]=true;
        }

        for(int i=2; i<=N; i++){
            if(vip[i] || vip[i-1]){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }

        System.out.println(dp[N]);
        br.close();
    }    
}
