package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 세탁소 사장 동혁
public class Math1_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int C = Integer.parseInt(br.readLine());
            int quarter = C/25;
            C %= 25;
            int dime = C/10;
            C %= 10;
            int nickel = C/5;
            C %= 5;
            bw.write(quarter+" "+dime+" "+nickel+" "+C+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
