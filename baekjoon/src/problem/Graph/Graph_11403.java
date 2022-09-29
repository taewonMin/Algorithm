package problem.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 경로 찾기
public class Graph_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++){
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                if(i==k || graph[i][k]==0) continue;
                for(int j=0; j<N; j++){
                    if(j==k || graph[k][j]==0) continue;
                    graph[i][j] = 1;
                }
            }
        }

        for(int[] arr : graph){
            for(int check : arr){
                bw.write(check+" ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
