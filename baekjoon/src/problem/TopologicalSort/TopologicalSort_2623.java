package problem.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 음악프로그램
public class TopologicalSort_2623 {
    public static int N;
    public static int[] indegree;
    public static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = cond[0];
        indegree = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cond[1]; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=1; j<input.length-1; j++){
                graph[input[j]].add(input[j+1]);
                indegree[input[j+1]]++;
            }
        }

        List<String> seq = topologicalSort();
        if(seq.size() < N){
            System.out.println(0);
        }else{
            for(String n : seq){
                System.out.println(n);
            }
        }

        br.close();
    }

    public static List<String> topologicalSort(){
        List<String> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                queue.offer(i);
                result.add(String.valueOf(i));
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int next : graph[node]){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                    result.add(String.valueOf(next));
                }
            }
        }

        return result;
    }
}
