package problem.Implement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 별 찍기 16
public class Imple_10991 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = sc.nextInt();
        for(int i=1; i<=N; i++){
            int n = 2*i-1; 
            for(int j=0; j<N-i; j++){
                bw.write(" ");
            }
            for(int j=0; j<n; j++){
                if(j%2==0){
                    bw.write("*");
                }else{
                    bw.write(" ");
                }
            }
            bw.newLine();
        }

        sc.close();
        bw.flush();
        bw.close();
    }
}
