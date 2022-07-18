package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주사위 게임
public class Math1_10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int score1 = 100;
        int score2 = 100;
        for(int i=0; i<n; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] < input[1]){
                score1 -= input[1];
            }else if(input[0] > input[1]){
                score2 -= input[0];
            }
        }

        System.out.println(score1);
        System.out.println(score2);

        br.close();
    }
}
