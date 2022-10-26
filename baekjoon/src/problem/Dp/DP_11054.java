package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 가장 긴 바이토닉 부분 수열
public class DP_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] leftDp = new int[N];
        for(int i=0; i<N; i++){
            leftDp[i] = 1;
            for(int j=0; j<i; j++){
                if(A[j] < A[i]){
                    leftDp[i] = Math.max(leftDp[i], leftDp[j]+1);
                }
            }
        }
        int[] rightDp = new int[N];
        for(int i=N-1; i>=0; i--){
            rightDp[i] = 1;
            for(int j=N-1; j>i; j--){
                if(A[j] < A[i]){
                    rightDp[i] = Math.max(rightDp[i], rightDp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, leftDp[i]+rightDp[i]);
        }
        
        System.out.println(max-1);
        br.close();
    }
}
