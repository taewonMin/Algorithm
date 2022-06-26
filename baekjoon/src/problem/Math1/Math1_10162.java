package problem.Math1;

import java.util.Scanner;

// 전자레인지
public class Math1_10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        if(T%10 != 0){
            System.out.println(-1);
        }else{
            int A = T/300;
            int B = T%300/60;
            int C = T%300%60/10;
            System.out.println(A+" "+B+" "+C);
        }

        sc.close();
    }
}
