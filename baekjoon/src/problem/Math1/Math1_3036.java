package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 링
public class Math1_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=1; i<rings.length; i++){
            int gcd = GCD(Math.max(rings[0], rings[i]), Math.min(rings[0], rings[i]));
            bw.write(rings[0]/gcd+"/"+rings[i]/gcd+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int GCD(int a, int b){
        if(a%b==0){
            return b;
        }
        return GCD(b, a%b);
    }
}
