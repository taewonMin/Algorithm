package problem.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N과 M 5
public class BackTracking_15654 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] input;
    public static int[] arr;
    public static List<String> selected = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[arr.length];

        Arrays.sort(arr);
        backTracking(0);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void backTracking(int k) throws IOException{
        if(k==input[1]){
            bw.write(String.join(" ", selected));
            bw.newLine();
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                selected.add(String.valueOf(arr[i]));

                backTracking(k+1);

                visited[i] = false;
                selected.remove(k);
            }
        }
    }
}
