package problem.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수들의 합 2
public class TwoPointer_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        int end = 0;
        int sum = 0;
        for(int start=0; start<N; start++){
            while(end < N && sum < M){
                sum += arr[end++];
            }
            if(sum==M){
                result++;
            }
            sum -= arr[start];
        }

        System.out.println(result);

        br.close();
    }
}
