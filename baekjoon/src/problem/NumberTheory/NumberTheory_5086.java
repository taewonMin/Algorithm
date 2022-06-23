package problem.NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 배수와 약수
public class NumberTheory_5086{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 0){
                break;
            }
            if(input[1] % input[0] == 0){
                bw.write("factor\n");
            }else if(input[0] % input[1] == 0){
                bw.write("multiple\n");
            }else{
                bw.write("neither\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}