package problem.Math1;

import java.util.Scanner;

// 완전제곱수
public class Math1_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = (int)Math.ceil(Math.sqrt(sc.nextInt()));
        int N = (int)Math.sqrt(sc.nextInt());
        int sum = 0;
        for(int i=M; i<=N; i++){
            sum += i*i;
        }

        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum+"\n"+M*M);
        }

        sc.close();
    }
}
