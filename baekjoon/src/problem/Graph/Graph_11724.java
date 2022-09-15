package problem.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class Graph_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]==false){
                visited[i] = true;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int j=1; j<=N; j++){
                        if(graph[node][j]==1 && visited[j]==false){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
