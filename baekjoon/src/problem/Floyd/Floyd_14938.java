package problem.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 서강그라운드
public class Floyd_14938 {
    public static int n, m;
    public static int[][] dis;
    public static int[] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = cond[0];
        m = cond[1];
        dis = new int[n+1][n+1];
        for(int[] arr : dis){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        item = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int i=0; i<cond[2]; i++){
            int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dis[road[0]][road[1]] = road[2];
            dis[road[1]][road[0]] = road[2];
        }

        floyd();
        
        int max = 0;
        for(int i=1; i<=n; i++){
            int cnt = item[i-1];
            for(int j=1; j<=n; j++){
                if(dis[i][j]<=m){
                    cnt += item[j-1];
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
        br.close();
    }

    public static void floyd(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(i==k || dis[i][k] == Integer.MAX_VALUE) continue;
                for(int j=1; j<=n; j++){
                    if(i==j || j==k || dis[k][j] == Integer.MAX_VALUE) continue;
                    if(dis[i][j] > dis[i][k]+dis[k][j]){
                        dis[i][j] = dis[i][k]+dis[k][j];
                    }
                }
            }
        }
    }
}
