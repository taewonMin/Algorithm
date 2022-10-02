package problem.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 회장뽑기
public class Graph_2660 {
    public static int N;
    public static int[][] members;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        members = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j) members[i][j] = Integer.MAX_VALUE;
            }
        }

        int x = 0;
        int y = 0;
        while(true){
            String[] input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            if(x==-1 && y==-1) break;
            members[x][y] = 1;
            members[y][x] = 1;
        }

        floyd();
        
        int[] score = new int[N+1];
        int minScr = Integer.MAX_VALUE;
        loop: for(int i=1; i<=N; i++){
            int max = 0;
            for(int j=1; j<=N; j++){
                if(members[i][j]==Integer.MAX_VALUE) continue loop;
                if(max < members[i][j]){
                    max = members[i][j];
                }
            }
            if(minScr > max){
                minScr = max;
            }
            score[i] = max;
        }


        List<String> candidate = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(score[i] == minScr){
                candidate.add(String.valueOf(i));
            }
        }
        bw.write(minScr+" "+candidate.size()+"\n");
        bw.write(String.join(" ", candidate));

        br.close();
        bw.flush();
        bw.close();
    }

    public static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(i==k || members[i][k]==Integer.MAX_VALUE) continue;
                for(int j=1; j<=N; j++){
                    if(j==k || members[k][j]==Integer.MAX_VALUE) continue;
                    if(members[i][j] > members[i][k]+members[k][j]){
                        members[i][j] = members[i][k]+members[k][j];
                    }
                }
            }
        }
    }
}
