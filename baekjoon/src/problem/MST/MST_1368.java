package problem.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 물대기
public class MST_1368 {
    public static List<Node>[] tree;
    public static boolean[] visited;

    static class Node implements Comparable<Node>{
        int v;
        int w;
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            int w = Integer.parseInt(br.readLine());
            tree[0].add(new Node(i, w));
            tree[i].add(new Node(0, w));
        }
        for(int i=0; i<N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                if(i!=j){
                    tree[i+1].add(new Node(j+1, input[j]));
                }
            }
        }

        System.out.println(prim());

        br.close();
    }

    public static int prim(){
        int result = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(visited[node.v]){
                continue;
            }
            visited[node.v] = true;
            result += node.w;
            
            for(Node next : tree[node.v]){
                if(visited[next.v]==false){
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}
