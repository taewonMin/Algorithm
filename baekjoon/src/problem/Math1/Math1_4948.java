package problem.Math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 베르트랑 공준
public class Math1_4948 {
    public static int MAX_SIZE = 123456*2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[MAX_SIZE+1];
        for(int i=2; i<=Math.sqrt(MAX_SIZE); i++){
            if(prime[i]==false){
                int j=2;
                while(i*j <= MAX_SIZE){
                    prime[i*j] = true;
                    j++;
                }
            }
        }

        int n = 0;
        while((n = Integer.parseInt(br.readLine())) != 0){
            int count = 0;
            for(int i=n+1; i<=2*n; i++){
                if(prime[i]==false){
                    count++;
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
