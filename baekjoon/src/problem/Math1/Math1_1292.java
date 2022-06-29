package problem.Math1;

import java.util.Scanner;

// 쉽게 푸는 문제
public class Math1_1292 {
    public static int[] prefix_sum = new int[1002];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        prefixSum();

        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(prefix_sum[B] - prefix_sum[A-1]);

        sc.close();
    }    
    
    public static void prefixSum(){
        int idx = 1;
        for(int i=1; i<prefix_sum.length; i++){
            for(int j=0; j<i; j++){
                prefix_sum[idx] = prefix_sum[idx-1] + i;
                idx++;
                if(idx == prefix_sum.length){
                    return;
                }
            }
        }
    }
}
