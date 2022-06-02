package problem.SetAndMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 대칭 차집합
public class SetAndMap_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> setA = new HashSet<Integer>();
        for(int i : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){
            setA.add(i);
        }

        for(int i : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){
            if(!setA.remove(i)){
                setA.add(i);
            }
        }

        System.out.println(setA.size());
        
        br.close();
    }
}
