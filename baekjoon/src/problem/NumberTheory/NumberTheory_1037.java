package problem.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 약수
public class NumberTheory_1037 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
       
       int N = Integer.parseInt(br.readLine());
       int[] measure = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       Arrays.sort(measure);

       if(N==1){
        System.out.println(measure[0]*measure[0]);
       }else{
        System.out.println(measure[0]*measure[N-1]);
       }

       br.close();
    }
}
