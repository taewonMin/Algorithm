package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 더하기 3
public class Math1_11023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        br.close();
    }
}
