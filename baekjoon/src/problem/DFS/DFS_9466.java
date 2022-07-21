package problem.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 텀 프로젝트
public class DFS_9466 {
    public static int[] student, state;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            student = new int[n+1];
            state = new int[n+1];

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<n; j++){
                student[j+1] = input[j];
            }

            for(int j=1; j<=n; j++){
                if(state[j]==0){
                    dfs(j);
                }
            } 
            int cnt = -1;
            for(int st : state){
                if(st!=-1){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        br.close();
    }

    public static void dfs(int start){
        int cursor = start;
        while(true){
            state[cursor] = start;
            cursor = student[cursor];
            if(state[cursor]==start){   // 이번 dfs에서 방문한 노드이면
                while(state[cursor]!=-1){
                    state[cursor] = -1;
                    cursor = student[cursor];
                }
                return;
            }else if(state[cursor]!=0){ // 이전 dfs에서 방문한 노드이면
                return;
            }
        }
    }
}
