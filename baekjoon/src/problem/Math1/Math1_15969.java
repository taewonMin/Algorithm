package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 행복
public class Math1_15969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 1001;
        int max = 0;
        for(int i=0; i<N; i++){
            min = Math.min(min, students[i]);
            max = Math.max(max, students[i]);
        }

        System.out.println(max - min);

        br.close();
    }
}
