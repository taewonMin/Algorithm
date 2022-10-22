package problem.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 다리 놓기
public class DP_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] dp = new int[input[0]+1][input[1]+1];
            Arrays.fill(dp[0], 1);
            for(int i=1; i<=input[0]; i++){
                for(int j=i; j<=input[1]; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
            }
            bw.write(dp[input[0]][input[1]]+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
