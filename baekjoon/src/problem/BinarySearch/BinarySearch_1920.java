package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 찾기
public class BinarySearch_1920 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int num : numbers){
            binarySearch(num);
        }

        br.close();
    }

    public static void binarySearch(int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] < target){
                start = mid+1;
            }else if(arr[mid] > target){
                end = mid-1;
            }else{
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
