package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 개수 세기
public class Imple_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int num : arr){
            if(num == V){
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
