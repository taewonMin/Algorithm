package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// A+B - 6
public class Math1_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int[] input = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            bw.write(input[0]+input[1]+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
