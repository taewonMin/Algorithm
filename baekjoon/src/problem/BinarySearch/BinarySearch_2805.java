package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 나무 자르기
public class BinarySearch_2805 {
    public static int N, M;
    public static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int max = 0;
        trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N; i++){
            if(max < trees[i]){
                max = trees[i];
            }
        }

        System.out.println(binarySearch(max-1));
        br.close();
    }

    public static int binarySearch(int maxHeight){
        int start = 0;
        int end = maxHeight;
        while(start <= end){
            int mid = (end+start)/2;
            long height = getTree(mid);
            if(height>=M){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start-1;
    }

    public static long getTree(int height){
        long sum = 0;
        for(int i=0; i<N; i++){
            if(trees[i] > height){
                sum += trees[i]-height;
            }
        }
        return sum;
    }
}
