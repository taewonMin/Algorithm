package problem.BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N과 M 9
public class BackTracking_15663 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        visited = new boolean[N];

        backTracking(0);

        sc.close();
        bw.flush();
        bw.close();
    }

    public static void backTracking(int k) throws IOException{
        if(k==M){
            bw.write(String.join(" ", result));
            bw.newLine();
            return;
        }

        int temp = 0;
        for(int i=0; i<N; i++){
            if(!visited[i] && temp != arr[i]){
                temp = arr[i];
                visited[i] = true;
                result.add(String.valueOf(temp));

                backTracking(k+1);

                visited[i] = false;
                result.remove(k);
            }
        }
    }
}
