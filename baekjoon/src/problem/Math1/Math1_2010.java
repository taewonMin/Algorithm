package problem.Math1;

import java.util.Scanner;

// 플러그
public class Math1_2010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            sc.nextLine();

            if(i==N-1){
                cnt += n;
            }else{
                cnt += n-1;
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}
