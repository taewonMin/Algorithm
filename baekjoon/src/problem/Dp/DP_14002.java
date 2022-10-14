package problem.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 가장 긴 증가하는 부분 수열 4
public class DP_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        int[] path = new int[N];
        for(int i=0; i<N; i++){
            path[i] = i;
        }

        dp[0] = 1;
        int max = 1;
        int idx = 0;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    path[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                idx = i;
            }
        }

        bw.write(max+"\n");
        List<String> result = new ArrayList<>();
        while(true){
            if(idx==path[idx]){
                result.add(String.valueOf(arr[idx]));
                break;
            }
            result.add(String.valueOf(arr[idx]));
            idx = path[idx];
        }

        for(int i=result.size()-1; i>=0; i--){
            bw.write(result.get(i)+" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
