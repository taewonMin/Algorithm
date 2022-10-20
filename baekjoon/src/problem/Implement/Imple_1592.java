package problem.Implement;

import java.util.Scanner;

// 영식이와 친구들
public class Imple_1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] score = new int[N];
        score[0] = 1;
        int cnt = 0;
        int idx = 0;
        while(score[idx] < M){
            if(score[idx]%2==1){
                idx = (idx+L)%N;
            }else{
                idx = (idx-L+N)%N;
            }
            score[idx]++;
            cnt++;
        }

        System.out.println(cnt);
    }
}
