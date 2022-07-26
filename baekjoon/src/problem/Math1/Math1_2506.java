package problem.Math1;

import java.util.Scanner;

// 점수계산
public class Math1_2506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int prev = 1;
        int sum = 0;
        for(int i=0; i<N; i++){
            int answer = sc.nextInt();
            if(answer == 1){
                sum += prev++;
            }else{
                prev = 1;
            }
        }

        System.out.println(sum);

        sc.close();
    }
}
