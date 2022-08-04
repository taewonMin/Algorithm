package problem.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 수 정렬하기 5
public class Sort_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(br.readLine())+1000000]++;
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                bw.write((i-1000000)+"\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
