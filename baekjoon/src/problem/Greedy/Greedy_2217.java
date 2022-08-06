package problem.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 로프
public class Greedy_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        for(int i=0; i<N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int result = 0;
        for(int i=1; i<=N; i++){
            result = Math.max(result, rope[N-i]*i);
        }

        System.out.println(result);

        br.close();
    }
}
