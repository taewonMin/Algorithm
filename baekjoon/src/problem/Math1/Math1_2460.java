package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 지능형 기차2
public class Math1_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int sum = 0;
        for(int i=0; i<10; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum -= input[0];
            sum += input[1];
            if(max < sum){
                max = sum;
            }
        }

        System.out.println(max);

        br.close();
    }
}
