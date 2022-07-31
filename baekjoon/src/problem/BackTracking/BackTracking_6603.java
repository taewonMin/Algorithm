package problem.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 로또
public class BackTracking_6603 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String[] arr = new String[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0]==0){
                break;
            }
            lotto(0, input[0]-6, 0, input);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void lotto(int cnt, int remain, int idx, int[] input) throws IOException{
        if(cnt==6){
            bw.write(String.join(" ", arr));
            bw.newLine();
            return;
        }

        arr[cnt] = String.valueOf(input[idx+1]);    
        lotto(cnt+1, remain, idx+1, input); // 선택
        if(remain > 0){
            lotto(cnt, remain-1, idx+1, input); // 미선택
        }
    }
}
