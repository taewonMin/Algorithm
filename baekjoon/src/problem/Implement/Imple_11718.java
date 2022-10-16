package problem.Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 그대로 출력하기
public class Imple_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while((line = br.readLine()) != null){
            bw.write(line+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}