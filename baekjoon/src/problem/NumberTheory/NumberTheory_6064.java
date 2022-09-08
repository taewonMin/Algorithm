package problem.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카잉 달력
public class NumberTheory_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[2]==input[0]){
                input[2] = 0;
            }
            if(input[3]==input[1]){
                input[3] = 0;
            }
            int lcm = input[0]*input[1]/gcd(input[0], input[1]);
            int cnt = -1;
            for(int i=input[2]; i<=lcm; i+=input[0]){
                if(i==0){
                    continue;
                }
                if(i%input[1] == input[3]){
                    cnt = i;
                    break;
                }
            }
            System.out.println(cnt);
        }
        
        br.close();
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
