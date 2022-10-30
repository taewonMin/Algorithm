package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 촌수계산
public class BFS_2644 {
    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree[input[0]].add(input[1]);
            tree[input[1]].add(input[0]);
        }

        System.out.println(bfs(cond[0], cond[1]));
        br.close();
    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,0});
        visited[x] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int next : tree[node[0]]){
                if(visited[next]) continue;
                if(next==y) return node[1]+1;
                visited[next] = true;
                queue.offer(new int[]{next, node[1]+1});
            }
        }


        return -1;
    }
}
