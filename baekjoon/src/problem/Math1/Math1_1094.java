package problem.Math1;

import java.util.Scanner;

// 막대기
public class Math1_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int[] bars = {64,32,16,8,4,2,1};
        int cur = 0;
        int cnt = 0;
        while(X!=0){
            if(bars[cur] > X){
                cur++;
            }else{
                X -= bars[cur++];
                cnt++;
            }
        }
        
        System.out.println(cnt);

        sc.close();
    }
}
