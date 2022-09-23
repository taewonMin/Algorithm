package problem.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 최단 경로
public class Dijkstra_1753{
    public static int v, e;
    public static List<Node>[] graph;
    public static int[] dis;

    static class Node {
        int distance;
        int idx;

        Node(int distance, int idx){
            this.distance = distance;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        v = Integer.parseInt(info[0]);
        e = Integer.parseInt(info[1]);
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        dis = new int[v+1];
        for(int i=1; i<=v; i++){
            if(i!=k){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<e; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[input[0]].add(new Node(input[1],input[2]));
        }

        dijkstra(v);

        br.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.distance - o2.distance);
        queue.offer(new Node(0, start));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(Node next : graph[node.idx]){
                if(dis[next.idx] > dis[node.idx]+next.distance){
                    dis[next.idx] = dis[node.idx]+next.distance;
                    queue.offer(new Node(next.idx, dis[next.idx]));
                }
            }
        }
    }
}