package problem.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 가운데에서 만나기
public class Floyd_21940 {
    public static int N;
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = cond[0];
        graph = new int[N+1][N+1];
        for(int[] arr : graph){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0; i<cond[1]; i++){
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edge[0]][edge[1]] = edge[2];
        }

        int K = Integer.parseInt(br.readLine());
        int[] friend = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();;

        floyd();

        List<String> city = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int x=1; x<=N; x++){
            int cnt = 0;
            for(int start : friend){
                if(start!=x){
                    cnt = Math.max(cnt, graph[start][x] + graph[x][start]);
                }
            }
            if(cnt < min){
                min = cnt;
                city.clear();
                city.add(String.valueOf(x));
            }else if(cnt == min){
                city.add(String.valueOf(x));
            }
        }

        System.out.println(String.join(" ", city));

        br.close();
    }

    public static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(i==k || graph[i][k]==Integer.MAX_VALUE) continue;
                for(int j=1; j<=N; j++){
                    if(i==j || j==k || graph[k][j]==Integer.MAX_VALUE) continue;
                    if(graph[i][j] > graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
    }
}
