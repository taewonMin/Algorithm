package problem.Math1;

import java.util.Scanner;

// 킹, 퀸, 룩, 비숍, 나이트, 폰
public class Math1_3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] chess = {1,1,2,2,2,8};
        for(int i=0; i<6; i++){
            chess[i] -= sc.nextInt();
        }

        for(int i : chess){
            System.out.print(i+" ");
        }

        sc.close();
    }
}
