package problem.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// List of Unique Numbers
public class TwoPointer_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[100001];

        long result = 0;
        int en = 0;
        for(int st=0; st<N; st++){
            while(en < N){
                if(visited[arr[en]]) break;
                visited[arr[en++]] = true;
            }
            result += en-st;
            visited[arr[st]] = false;
        }

        System.out.println(result);
        br.close();
    }
}
