package problem.Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 점수 집계
public class Imple_9076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(input);
            if(input[3]-input[1] >= 4){
                bw.write("KIN\n");
            }else{
                int sum = 0;
                for(int i=1; i<4; i++){
                    sum += input[i];
                }
                bw.write(sum+"\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
