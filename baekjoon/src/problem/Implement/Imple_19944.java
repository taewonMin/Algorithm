package problem.Implement;

import java.util.Scanner;

// 뉴비의 기준은 뭘까?
public class Imple_19944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        if(M <= 2){
            System.out.println("NEWBIE!");
        }else if(M <= N){
            System.out.println("OLDBIE!");
        }else{
            System.out.println("TLE!");
        }

        sc.close();
    }
}
