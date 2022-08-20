package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 타임 카드
public class Math1_5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startTime = input[0]*3600 + input[1]*60 + input[2];
            int endTime = input[3]*3600 + input[4]*60 + input[5];
            int gap = endTime - startTime;
            int h = gap/3600;
            gap %= 3600;
            int m = gap/60;
            gap %= 60;
            System.out.println(h+" "+m+" "+gap);
        }


        br.close();
    }
}
