package problem.Implement;

import java.util.Scanner;

// 숫자
public class Imple_10093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long max = Math.max(A, B);
        long min = Math.min(A, B);

        if(max==min || max-min==1){
            System.out.println(0);
        }else{
            System.out.println(max-min-1);
            for(long i=min+1; i<max; i++){
                System.out.print(i+" ");
            }
        }

        sc.close();
    }
}
