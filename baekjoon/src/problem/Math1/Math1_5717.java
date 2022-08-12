package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 상근이의 친구들
public class Math1_5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0]==0 && input[1]==0){
                break;
            }

            bw.write(input[0]+input[1]+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
