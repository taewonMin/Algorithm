package problem.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 나는야 포켓몬 마스터 이다솜
public class SetAndMap_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] pocketmon = new String[input[0]];
        for(int i=0; i<input[0]; i++){
            pocketmon[i] = br.readLine();
        }

        String[] sortArray = Arrays.copyOf(pocketmon, pocketmon.length);
        Arrays.sort(sortArray);

        for(int i=0; i<input[1]; i++){
            String quiz = br.readLine();
            if(quiz.matches("\\d+")){
                bw.write(pocketmon[Integer.parseInt(quiz)-1]+"\n");
            }else{

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
