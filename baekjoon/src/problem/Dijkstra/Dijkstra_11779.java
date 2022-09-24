package problem.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 최소비용 구하기 2
public class Dijkstra_11779 {
    public static List<Node>[] graph;
    public static int[] dis;
    public static int[] pre;

    static class Node {
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        dis = new int[n+1];
        pre = new int[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
            dis[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<m; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[input[0]].add(new Node(input[1], input[2]));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        dijkstra(start);

        bw.write(dis[end]+"\n");
        int vertex = end;
        List<Integer> path = new ArrayList<>();
        while(vertex!=0){
            path.add(vertex);
            vertex = pre[vertex];
        }
        bw.write(path.size()+"\n");
        for(int i=path.size()-1; i>=0; i--){
            bw.write(path.get(i)+" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        queue.offer(new Node(start, 0));
        dis[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(dis[node.v] != node.w) continue;

            for(Node next : graph[node.v]){
                if(dis[next.v] > dis[node.v]+next.w){
                    dis[next.v] = dis[node.v]+next.w;
                    queue.offer(new Node(next.v, dis[next.v]));
                    pre[next.v] = node.v;
                }
            }
        }
    }
}
