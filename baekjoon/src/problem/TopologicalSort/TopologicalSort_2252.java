package problem.TopologicalSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄 세우기
public class TopologicalSort_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] deg = new int[N+1];
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            deg[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(deg[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            bw.write(node+" ");
            for(int child : graph[node]){
                deg[child]--;
                if(deg[child]==0){
                    queue.offer(child);
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
