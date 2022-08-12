package problem.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 공주님의 정원
public class Greedy_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for(int i=0; i<N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            flowers[i] = new int[]{input[0]*100+input[1], input[2]*100+input[3]};
        }

        // 끝날짜가 늦은순, 같으면 시작날짜가 빠른순
        Arrays.sort(flowers, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o2[1]==o1[1]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            };
        });

        int start = 301;
        int end = 1130;
        int result = 0;
        int idx = N;
        boolean unselected;
        while(start<=end){
            unselected = true;
            for(int i=0; i<idx; i++){
                if(flowers[i][0] <= start){
                    start = flowers[i][1];
                    idx = i;
                    result++;
                    unselected = false;
                    break;
                }
            }

            if(unselected){
                result = 0;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }
}
