package problem.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class MST_1197_Kruskal {
    public static int[] parent;
    public static Edge[] edges;

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int w;

        Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
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
        parent = new int[V+1];
        edges = new Edge[E];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges, (o1, o2) -> o1.w - o2.w);

        System.out.println(kruskal());
        br.close();
    }

    public static int kruskal(){
        int result = 0;
        
        for(int i=0; i<edges.length; i++){
            int from = edges[i].from;
            int to = edges[i].to;
            if(find(from)!=find(to)){
                union(from, to);
                result += edges[i].w;
            }
        }

        return result;
    }

    public static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}
