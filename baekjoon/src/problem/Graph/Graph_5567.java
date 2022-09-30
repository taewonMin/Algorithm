package problem.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 결혼식
public class Graph_5567 {
    public static int N;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();    // 노드 번호, 거리
        queue.offer(new int[]{1, 0});
        visited[1] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int next : graph[node[0]]){
                if(visited[next]) continue;
                if(node[1] == 0){
                    queue.offer(new int[]{next, node[1]+1});
                }
                visited[next] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
