package problem.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 물대기
public class MST_1368_Kruskal {
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

        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        edges = new Edge[N*(N+1)/2];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i<N; i++){
            int w = Integer.parseInt(br.readLine());
            edges[i] = new Edge(0, i+1, w);
        }
        int idx = N;
        for(int i=1; i<=N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=i; j<N; j++){
                edges[idx++] = new Edge(i, j+1, input[j]);
            }
        }

        Arrays.sort(edges);

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
