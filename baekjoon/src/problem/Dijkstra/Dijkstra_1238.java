package problem.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 파티
public class Dijkstra_1238 {
    public static int N;
    public static List<Node>[] graph;

    static class Node{
        int idx;
        int w;

        Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<input[1]; i++){
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int max = 0;
        int[] startX = dijkstra(input[2]);
        for(int i=1; i<=N; i++){
            if(i!=input[2]){
                int dis = dijkstra(i)[input[2]] + startX[i];
                max = Math.max(max, dis);
            }
        }

        System.out.println(max);
        br.close();
    }

    public static int[] dijkstra(int start){
        int[] dis = new int[N+1];
        for(int i=1; i<=N; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.w-o2.w));
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(dis[node.idx]!=node.w) continue;

            for(Node next : graph[node.idx]){
                if(dis[next.idx] > dis[node.idx]+next.w){
                    dis[next.idx] = dis[node.idx]+next.w;
                    queue.offer(new Node(next.idx, dis[next.idx]));
                }
            }
        }

        return dis;
    }
}
