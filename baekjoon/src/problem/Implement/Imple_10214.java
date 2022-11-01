package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baseball
public class Imple_10214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int yonsei = 0;
            int korea = 0;
            for(int i=0; i<9; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                yonsei += input[0];
                korea += input[1];
            }
            if(yonsei > korea){
                System.out.println("Yonsei");
            }else if(yonsei < korea){
                System.out.println("Korea");
            }else{
                System.out.println("Draw");
            }
        }
        
        br.close();
    }
}
