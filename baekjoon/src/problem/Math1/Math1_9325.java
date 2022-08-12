package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 얼마?
public class Math1_9325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int sum = s;
            for(int j=0; j<n; j++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                sum += input[0]*input[1];
            }
            bw.write(sum+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
