package problem.Implement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 별 찍기 - 12
public class Imple_2522 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        for(int i=1; i<=N; i++){
            for(int j=0; j<N-i; j++){
                bw.write(" ");
            }
            for(int j=0; j<i; j++){
                bw.write("*");
            }
            bw.newLine();
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                bw.write(" ");
            }
            for(int j=0; j<N-i; j++){
                bw.write("*");
            }
            bw.newLine();
        }

        sc.close();
        bw.flush();
        bw.close();
    }
}
