package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주사위
public class Math1_9295 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++){
            int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
            System.out.println("Case "+i+": "+sum);
        }

        br.close();
    }
}
