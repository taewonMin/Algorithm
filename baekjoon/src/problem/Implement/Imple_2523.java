package problem.Implement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 별 찍기 13
public class Imple_2523 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<i+1; j++){
                bw.write("*");
            }
            bw.newLine();
        }
        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                bw.write("*");
            }
            bw.newLine();
        }

        sc.close();
        bw.flush();
        bw.close();
    }
}
