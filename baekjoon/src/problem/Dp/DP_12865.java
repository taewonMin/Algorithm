package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class DP_12865{
    public static int[][] items;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        items = new int[N][2];
        dp = new int[N+1][K+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            items[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                int w = items[i-1][0];
                if(j < w){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], items[i-1][1]+dp[i-1][j-w]);
                }
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }
}