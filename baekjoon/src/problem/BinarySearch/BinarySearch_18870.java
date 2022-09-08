package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 좌표 압축
public class BinarySearch_18870 {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] temp = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for(int i=0; i<temp.length; i++){
            if(i==0 || temp[i-1] != temp[i]){
                list.add(temp[i]);
            }
        }

        for(int num : arr){
            bw.write(lower_bound(num)+" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int lower_bound(int target){
        int start = 0;
        int end = list.size()-1;
        while(start <= end){
            int mid = (end+start)/2;
            if(target <= list.get(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
