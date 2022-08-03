package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 스티커 붙이기
public class Simulation_18808 {
    public static int N,M;
    public static boolean[][] notebook;
    public static int[][][] stickers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        notebook = new boolean[N][M];
        stickers = new int[input[2]][][];
        for(int i=0; i<input[2]; i++){
            int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stickers[i] = new int[size[0]][size[1]];
            for(int j=0; j<size[0]; j++){
                stickers[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        for(int i=0; i<stickers.length; i++){
            checkSticker(i);
        }

        int result = 0;
        for(boolean[] arr : notebook){
            for(boolean check : arr){
                if(check){
                    result++;
                }
            }
        }
        System.out.println(result);

        br.close();
    }

    public static void checkSticker(int stickerNum){
        int[][] sticker = stickers[stickerNum];
        for(int k=0; k<4; k++){ // 회전
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(isPossible(sticker, i, j)){
                        return;
                    }
                }
            }
            if(k<3){
                sticker = rotation(sticker);
            }
        }
    }

    // 스티커 붙일 수 있는지 체크
    public static boolean isPossible(int[][] sticker, int x, int y){
        List<int[]> temp = new ArrayList<>();
        for(int i=0; i<sticker.length; i++){
            for(int j=0; j<sticker[0].length; j++){
                if(sticker[i][j]==1){
                    if(oob(x+i, y+j) || notebook[x+i][y+j]){
                        return false;
                    }else{
                        temp.add(new int[]{x+i, y+j});
                    }
                }
            }
        }

        for(int[] arr : temp){
            notebook[arr[0]][arr[1]] = true;
        }
        return true;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    // 스티커 회전
    public static int[][] rotation(int[][] origin){
        int[][] rotate = new int[origin[0].length][origin.length];
        for(int i=0; i<rotate.length; i++){
            for(int j=0; j<rotate[0].length; j++){
                rotate[i][j] = origin[origin.length-1-j][i];
            }
        }
        return rotate;
    }

}
