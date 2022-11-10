package problem.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 누울 자리를 찾아라
public class Imple_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        int rowCnt = 0;
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(map[i][j]=='.'){
                    cnt++;
                    if(cnt==2){
                        rowCnt++;
                    }
                }else{
                    cnt = 0;
                }
            }
        }
        int colCnt = 0;
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(map[j][i]=='.'){
                    cnt++;
                    if(cnt==2){
                        colCnt++;
                    }
                }else{
                    cnt = 0;
                }
            }
        }

        System.out.println(rowCnt+" "+colCnt);

        br.close();
    }
}
