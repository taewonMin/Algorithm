package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 과자 나눠주기
public class BinarySearch_16401 {
    public static int N, M;
    public static int[] cookies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[1];
        M = input[0];
        cookies = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cookies);

        System.out.println(binarySearch());

        br.close();
    }

    public static int binarySearch(){
        int start = 1;
        int end = cookies[cookies.length-1];

        while(start <= end){
            int mid = (end+start)/2;
            long cnt = 0;
            for(int num : cookies){
                cnt += num/mid;
            }

            if(cnt < M){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start-1;
    }
}
