package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시험 점수
public class Math1_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int sum2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println(Math.max(sum1, sum2));

        br.close();
    }
}
