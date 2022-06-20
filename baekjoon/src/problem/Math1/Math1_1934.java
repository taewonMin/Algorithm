package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 최소공배수
public class Math1_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(input[0]*input[1] / gcd(Math.max(input[0], input[1]), Math.min(input[0], input[1]))+"\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    public static int gcd(int n, int m){
        if(n % m == 0){
            return m;
        }else{
            return gcd(m, n%m);
        }
    }
}
