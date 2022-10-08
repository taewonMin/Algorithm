package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 스타트와 링크
public class Simulation_14889 {
    public static int N;
    public static int[][] ability;
    public static boolean[] team;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        team = new boolean[N];
        for(int i=0; i<N; i++){
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        selectTeam(0, 0);
        System.out.println(min);

        br.close();
    }

    public static void selectTeam(int k, int start){
        if(k==N/2){
            checkDiffer();
            return;
        }

        for(int i=start; i<N; i++){
            if(team[i]==false){
                team[i] = true;
                selectTeam(k+1, i+1);
                team[i] = false;
            }
        }
    }

    public static void checkDiffer(){
        int teamScore = 0;
        int oppScore = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(team[i] && team[j]){
                    teamScore += ability[i][j];
                }else if(team[i]==false && team[j]==false){
                    oppScore += ability[i][j];
                }
            }
        }
        min = Math.min(min, Math.abs(teamScore-oppScore));
    }
}
