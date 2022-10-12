package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
public class BinarySearch_1654 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        System.out.println(binarySearch(N));

        br.close();
    }

    public static long binarySearch(int target){
        long start = 1;
        long end = arr[arr.length-1];
        while(start <= end){
            long mid = (end+start)/2;
            long cnt = 0;
            for(int num : arr){
                cnt += num/mid;
            }
            if(cnt < target){
                end = mid-1;
            }else if(cnt >= target){
                start = mid+1;
            }
        }
        return start-1;
    }
}
