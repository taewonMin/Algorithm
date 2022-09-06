package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 연산자 끼워넣기
public class Simulation_14888 {
    public static int N;
    public static int[] numbers;
    public static int[] opers;
    public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        opers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        calc(0,numbers[0]);
        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static void calc(int k, int result){
        if(k==N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        for(int i=0; i<4; i++){
            if(opers[i] > 0){
                opers[i]--;
                if(i==0){
                    calc(k+1, result+numbers[k+1]);
                }else if(i==1){
                    calc(k+1, result-numbers[k+1]);
                }else if(i==2){
                    calc(k+1, result*numbers[k+1]);
                }else{
                    if(result < 0){
                        calc(k+1, (-1*result/numbers[k+1])*-1);
                    }else{
                        calc(k+1, result/numbers[k+1]);
                    }
                }
                opers[i]++;
            }
        }
    }
}
