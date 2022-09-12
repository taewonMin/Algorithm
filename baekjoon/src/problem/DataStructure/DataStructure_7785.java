package problem.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 회사에 있는 사람
public class DataStructure_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> log = new HashSet<>();
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            if(log.remove(input[0])==false){
                log.add(input[0]);
            }
        }

        log.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        br.close();
    }    
}
