package problem.Floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 플로이드
public class Floyd_11404 {
    public static int n;
    public static int[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dis = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j){
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<m; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dis[input[0]][input[1]] = Math.min(input[2], dis[input[0]][input[1]]);
        }

        floyd();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dis[i][j]==Integer.MAX_VALUE){
                    bw.write(0+" ");
                }else{
                    bw.write(dis[i][j]+" ");
                }
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void floyd(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j || dis[j][i]==Integer.MAX_VALUE) continue;
                for(int k=1; k<=n; k++){
                    if(i==k || j==k || dis[i][k]==Integer.MAX_VALUE) continue;
                    dis[j][k] = Math.min(dis[j][k], dis[j][i]+dis[i][k]);
                }
            }
        }
    }
}
