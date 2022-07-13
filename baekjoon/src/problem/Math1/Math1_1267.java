package problem.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 핸드폰 요금
public class Math1_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumY = 0;
        int sumM = 0;
        for(int i : time){
            sumY += i/30 * 10 + 10;
            sumM += i/60 * 15 + 15;
        }
        
        if(sumY > sumM){
            System.out.println("M "+sumM);
        }else if(sumY == sumM){
            System.out.println("Y M "+sumY);
        }else{
            System.out.println("Y "+sumY);
        }

        br.close();
    }
}
