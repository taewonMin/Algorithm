package problem.Floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 플로이드 2
public class Floyd_11780 {
    public static int[][] graph;
    public static int[][] dir;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        dir = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j){
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<m; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(graph[input[0]][input[1]] > input[2]){
                graph[input[0]][input[1]] = input[2];
                dir[input[0]][input[1]] = input[1];
            }
        }

        floyd();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                bw.write((graph[i][j]==Integer.MAX_VALUE ? "0" : graph[i][j])+" ");
            }
            bw.newLine();
        }
        for(int i=1; i<=n; i++){                                                             
            for(int j=1; j<=n; j++){
                if(i==j || graph[i][j]==Integer.MAX_VALUE) {
                    bw.write("0\n");
                }else{
                    List<String> list = new ArrayList<>();
                    int start = i;
                    while(start != j){
                        list.add(String.valueOf(start));
                        start = dir[start][j];
                    }
                    list.add(String.valueOf(start));
                    bw.write(list.size()+" "+String.join(" ", list)+"\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void floyd(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(k==i || graph[i][k]==Integer.MAX_VALUE) continue;
                for(int j=1; j<=n; j++){
                    if(k==j || graph[k][j]==Integer.MAX_VALUE) continue;
                    if(graph[i][j] > graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                        dir[i][j] = dir[i][k];
                    }
                }
            }
        }
    }
}