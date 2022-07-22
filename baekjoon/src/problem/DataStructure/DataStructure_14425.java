package problem.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문자열 집합
public class DataStructure_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] setS = new String[input[0]];
        for(int i=0; i<input[0]; i++){
            setS[i] = br.readLine();
        }
        Arrays.sort(setS);
        
        int result = 0;
        for(int j=0; j<input[1]; j++){
            if(binarySearch(setS, br.readLine())){
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }

    public static boolean binarySearch(String[] setS, String target){
        int lo = 0;
        int hi = setS.length-1;
        int mid = (lo+hi)/2;
        while(lo<=hi){
            if(setS[mid].compareTo(target)==0){
                return true;
            }else if(setS[mid].compareTo(target) > 0){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            mid = (lo+hi)/2;
        }
        return false;
    }
}
