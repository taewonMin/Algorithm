package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 피시방 알바
public class Imple_1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        boolean[] check = new boolean[101];
        for(int num : people){
            if(check[num]==false){
                check[num] = true;
            }else{
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
