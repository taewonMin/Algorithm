package problem.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1,2,3 더하기 3
public class DP_15988 {
    public static int[] dp = new int[1000001];
    public static int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            bw.write(getNum(n)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int getNum(int n){
        if(dp[n]!=0) return dp[n];
        return dp[n] = ((getNum(n-3)+getNum(n-2))%MOD+getNum(n-1))%MOD;
    }
}
