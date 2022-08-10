package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 톱니바퀴
public class Simulation_14891 {
    public static int GEAR_CNT = 8;
    public static int[][] gears = new int[4][GEAR_CNT];
    public static int[] pointer = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            gears[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            rotation(num, dir, num);
        }

        int result = 0;
        int score = 1;
        for(int i=0; i<4; i++){
            result += gears[i][pointer[i]]==1 ? score : 0;
            score *= 2;
        }

        System.out.println(result);

        br.close();
    }

    public static void rotation(int num, int dir, int start){
        // 왼쪽 톱니가 돌아가는 경우
        if(num <= start && num-1 >= 0 && gears[num][(pointer[num]+GEAR_CNT-2)%GEAR_CNT] != gears[num-1][(pointer[num-1]+GEAR_CNT+2)%GEAR_CNT]){
            rotation(num-1, dir*-1, start);
        }
        // 오른쪽 톱니가 돌아가는 경우
        if(num >= start && num+1 < 4 && gears[num][(pointer[num]+GEAR_CNT+2)%GEAR_CNT] != gears[num+1][(pointer[num+1]+GEAR_CNT-2)%GEAR_CNT]){
            rotation(num+1, dir*-1, start);
        }
        
        // 회전
        pointer[num] = (pointer[num]+GEAR_CNT-dir)%GEAR_CNT;
    }
}
