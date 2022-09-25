package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 명령 프롬프트
public class Imple_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        for(int i=1; i<N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<input.length; j++){
                if(str[j]=='?') continue;
                if(str[j]!=input[j]){
                    str[j]='?';
                }
            }
        }

        String answer = "";
        for(char c : str){
            answer += c;
        }

        System.out.println(answer);

        br.close();
    }
}
