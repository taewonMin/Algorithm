package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 아이들은 사탕을 좋아해
public class Math1_9550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] candy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cnt = 0;
            for(int j=0; j<input[0]; j++){
                cnt += candy[j]/input[1];
            }
            System.out.println(cnt);
        }

        br.close();
    }
}
