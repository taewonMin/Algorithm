package problem.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

// 키로거
public class DataStructure_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            LinkedList<Character> keylogger = new LinkedList<>();
            int cursor = 0;

            for(char c : br.readLine().toCharArray()){
                if(c == '<'){
                    if(cursor > 0){
                        cursor--;
                    }
                }else if(c == '>'){
                    if(cursor < keylogger.size()){
                        cursor++;
                    }
                }else if(c == '-'){
                    if(cursor > 0){
                        keylogger.remove(--cursor);
                    }
                }else{
                    keylogger.add(cursor++, c);
                }
            }
            
            for(char c : keylogger){
                bw.write(c);
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
