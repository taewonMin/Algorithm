package problem.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 바이러스
public class Graph_2606 {
    public static boolean[][] computer;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        computer = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            computer[start][end] = true;
            computer[end][start] = true;
        }

        System.out.println(search());

        br.close();
    }

    public static int search(){
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=1; i<computer[node].length; i++){
                if(computer[node][i] && visited[i]==false){
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
