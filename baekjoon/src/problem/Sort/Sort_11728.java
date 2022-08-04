package problem.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 배열 합치기
public class Sort_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idxA = 0;
        int idxB = 0;
        int idx = 0;
        while(idx < A.length+B.length){
            if(idxA==A.length){
                bw.write(B[idxB++]+" ");
            }else if(idxB==B.length){
                bw.write(A[idxA++]+" ");
            }else{
                if(A[idxA] < B[idxB]){
                    bw.write(A[idxA++]+" ");
                }else{
                    bw.write(B[idxB++]+" ");
                }
            }
            idx++;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
