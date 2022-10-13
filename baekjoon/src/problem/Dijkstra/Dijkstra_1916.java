package problem.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 최소비용 구하기
public class Dijkstra_1916 {
    public static int N;
    public static List<Node>[] graph;
    public static int[] dis;

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

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        dis = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
            dis[i] = Integer.MAX_VALUE;
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            int[] bus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[bus[0]].add(new Node(bus[1], bus[2]));
        }

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(dijkstra(input[0], input[1]));

        br.close();
    }

    public static int dijkstra(int start, int dst){
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

        return dis[dst];
    }
}
