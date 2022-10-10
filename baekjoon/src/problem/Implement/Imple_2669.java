package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 직사각형 네개의 합집합의 면적 구하기
public class Imple_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] square = new int[100][100];
        int result = 0;
        for(int i=0; i<4; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=input[0]-1; j<input[2]-1; j++){
                for(int k=input[1]-1; k<input[3]-1; k++){
                    if(square[j][k]==0){
                        square[j][k] = 1;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
