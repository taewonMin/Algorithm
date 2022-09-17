package problem.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class MST_1197_Prim {
    public static List<Edge>[] tree;
    public static boolean[] visited;
    static class Edge implements Comparable<Edge>{
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        tree = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i=1; i<=V; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[a].add(new Edge(b, w));
            tree[b].add(new Edge(a, w));
        }

        System.out.println(prim());
        br.close();
    }

    public static int prim(){
        int result = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1,0));

        while(!queue.isEmpty()){
            Edge edge = queue.poll();

            if(visited[edge.v]){
                continue;
            }
            visited[edge.v] = true;
            result += edge.w;

            for(Edge next : tree[edge.v]){
                if(visited[next.v]==false){
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}
