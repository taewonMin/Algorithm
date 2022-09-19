package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 차집합
public class BinarySearch_1822 {
    public static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> result = new ArrayList<>();
        for(int num : a){
            if(isExistInB(num)==false){
                result.add(num);
            }
        }

        bw.write(result.size()+"\n");
        for(int num : result){
            bw.write(num+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isExistInB(int num){
        int lo = 0;
        int hi = b.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(b[mid] == num){
                return true;
            }else if(b[mid] < num){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }
}
