package problem.Recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 별 찍기 - 11
public class Recursion_2448 {
    public static String[][] star;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        star = new String[N][2*N-1];

        printStar(N, 0, 0);

        for(String[] strs : star){
            for(String str : strs){
                if(str==null){
                    bw.write(" ");
                }else{
                    bw.write(str);
                }
            }
            bw.newLine();
        }

        sc.close();
        bw.flush();
        bw.close();
    }

    public static void printStar(int N, int x, int y){
        if(N==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<5; j++){
                    if(i==0){
                        if(j==2){
                            star[y+i][x+j] = "*";
                        }
                    }else if(i==1){
                        if(j==1 || j==3){
                            star[y+i][x+j] = "*";
                        }
                    }else{
                        star[y+i][x+j] = "*";
                    }
                }
            }
            return;
        }
        printStar(N/2, x+N/2, y);
        printStar(N/2, x, y+N/2);
        printStar(N/2, x+N, y+N/2);
    }
}
