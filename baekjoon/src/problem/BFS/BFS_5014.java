package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 스타트링크
public class BFS_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[input[0]+1];
        int start = input[1];
        int target = input[2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int cnt = -1;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            if(pos[0] == target){
                cnt = pos[1];
                break;
            }

            int up = pos[0]+input[3];
            if(up <= input[0] && visited[up]==false){
                queue.offer(new int[]{up, pos[1]+1});
                visited[up] = true;
            }

            int down = pos[0]-input[4];
            if(down > 0 && visited[down]==false){
                queue.offer(new int[]{down, pos[1]+1});
                visited[down] = true;
            }
        }

        if(cnt == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(cnt);
        }
        br.close();
    }
}
