package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 세 수의 합
public class BinarySearch_2295 {
    public static List<Integer> two = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                two.add(arr[i]+arr[j]);
            }
        }
        Collections.sort(two);

        iter: for(int i=N-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                int num = arr[i] - arr[j];
                if(binarySearch(num)){
                    System.out.println(arr[i]);
                    break iter;
                }
            }
        }

        br.close();
    }

    public static boolean binarySearch(int target){
        int start = 0;
        int end = two.size()-1;
        while(start <= end){
            int mid = (end+start)/2;
            if(two.get(mid) < target){
                start = mid+1;
            }else if(two.get(mid) > target){
                end = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
