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
    public static int N;
    public static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = numbers[0];
            if(N==0){
                break;
            }
            // lotto(0, N-6, 0);
            dfs(0, 0);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 백트래킹 방법
    public static void lotto(int cnt, int remain, int idx) throws IOException{
        if(cnt==6){
            bw.write(String.join(" ", arr));
            bw.newLine();
            return;
        }

        arr[cnt] = String.valueOf(numbers[idx+1]);    
        lotto(cnt+1, remain, idx+1); // 선택
        if(remain > 0){
            lotto(cnt, remain-1, idx+1); // 미선택
        }
    }

    // dfs
    public static void dfs(int cnt, int start) throws IOException{
        if(cnt == 6){
            bw.write(String.join(" ", arr));
            bw.newLine();
            return;
        }

        for(int i=start; i<N; i++){
            arr[cnt] = String.valueOf(numbers[i+1]);
            dfs(cnt+1, i+1);
        }
    }
}
