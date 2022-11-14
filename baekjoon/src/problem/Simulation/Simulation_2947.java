package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 나무 조각
public class Simulation_2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean sortComplete = false;
        while(sortComplete==false){
            sortComplete = true;
            for(int i=0; i<arr.length-1; i++){
                boolean isChanged = false;
                if(arr[i] > arr[i+1]){
                    isChanged = true;
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
                if(isChanged){
                    String str = "";
                    for(int num : arr){
                        str += num+" ";
                    }
                    System.out.println(str);
                    sortComplete = false;
                }
            }
        }

        br.close();
    }
}
