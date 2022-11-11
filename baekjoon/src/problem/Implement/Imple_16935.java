package problem.Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 배열 돌리기 3
public class Imple_16935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[input[0]][input[1]];
        for(int i=0; i<input[0]; i++){
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] R = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int r : R){
            matrix = rotate(r, matrix);
        }

        for(int[] i : matrix){
            for(int num : i){
                bw.write(num+" ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int[][] rotate(int r, int[][] matrix){
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] result = new int[N][M];
        switch(r){
            case 1:
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        result[i][j] = matrix[N-1-i][j];
                    }
                }
                break;
            case 2:
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        result[i][j] = matrix[i][M-1-j];
                    }
                }
                break;
            case 3:
                result = new int[M][N];
                for(int i=0; i<M; i++){
                    for(int j=0; j<N; j++){
                        result[i][j] = matrix[N-1-j][i];
                    }
                }
                break;
            case 4:
                result = new int[M][N];
                for(int i=0; i<M; i++){
                    for(int j=0; j<N; j++){
                        result[i][j] = matrix[j][M-1-i];
                    }
                }
                break;
            case 5:
                for(int i=0; i<N/2; i++){
                    for(int j=0; j<M/2; j++){
                        result[i][j] = matrix[i+N/2][j];
                    }
                }
                for(int i=0; i<N/2; i++){
                    for(int j=M/2; j<M; j++){
                        result[i][j] = matrix[i][j-M/2];
                    }
                }
                for(int i=N/2; i<N; i++){
                    for(int j=M/2; j<M; j++){
                        result[i][j] = matrix[i-N/2][j];
                    }
                }
                for(int i=N/2; i<N; i++){
                    for(int j=0; j<M/2; j++){
                        result[i][j] = matrix[i][j+M/2];
                    }
                }
                break;
            case 6:
                for(int i=0; i<N/2; i++){
                    for(int j=0; j<M/2; j++){
                        result[i][j] = matrix[i][j+M/2];
                    }
                }
                for(int i=0; i<N/2; i++){
                    for(int j=M/2; j<M; j++){
                        result[i][j] = matrix[i+N/2][j];
                    }
                }
                for(int i=N/2; i<N; i++){
                    for(int j=M/2; j<M; j++){
                        result[i][j] = matrix[i][j-M/2];
                    }
                }
                for(int i=N/2; i<N; i++){
                    for(int j=0; j<M/2; j++){
                        result[i][j] = matrix[i-N/2][j];
                    }
                }
                break;
        }

        return result;
    }
}
