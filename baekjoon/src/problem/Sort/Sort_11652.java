package problem.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카드
public class Sort_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        int maxIdx = 0;
        int cnt = 1;
        long maxCnt = 1;
        for(int i=1; i<N; i++){
            if(arr[i] != arr[i-1]){
                cnt = 1;
            }else{
                cnt++;
            }
            if(cnt > maxCnt){
                maxCnt = cnt;
                maxIdx = i;
            }
        }

        System.out.println(arr[maxIdx]);

        br.close();
    }
}
