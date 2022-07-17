package problem.Math1;

import java.util.Scanner;

// 대회 or 인턴
public class Math1_2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        while(N>0 && M>0 && K>0){
            int manCnt = (int)(M - Math.ceil(N/2d));
            if(manCnt >= 0){ // 남자가 더 많거나 딱 맞으면
                M--;
                K--;
            }else{  // 여자가 남으면
                N--;
                K--;
            }
        }

        System.out.println(Math.min(N/2, M));

        sc.close();
    }
}
