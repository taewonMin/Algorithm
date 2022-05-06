package problem.Conditionals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 오븐 시계
public class Conditionals_2525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] startTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cookingTime = Integer.parseInt(br.readLine());
        
        int time = startTime[1]+cookingTime;
        int minute = time % 60;
        int hour = (time / 60 + startTime[0]) % 24;
        bw.write(hour + " " + minute);

        br.close();
        bw.flush();
        bw.close();
    }
}
