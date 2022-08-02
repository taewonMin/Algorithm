package problem.BackTracking;

import java.util.Scanner;

// 계란으로 계란치기
public class BackTracking_16987 {
    public static int N;
    public static int[] durability;
    public static int[] weight;
    public static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        durability = new int[N];
        weight = new int[N];

        for(int i=0; i<N; i++){
            durability[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            sc.nextLine();
        }

        egg(0, 0);

        System.out.println(result);

        sc.close();
    }

    public static void egg(int start, int brokenCnt){
        while(start < N && durability[start] <= 0){
            start++;
        }
        if(start == N || brokenCnt >= N-1){
            result = Math.max(result, brokenCnt);
            return;
        }
        for(int i=0; i<N; i++){
            if(i!=start && durability[i] > 0){
                durability[start] -= weight[i];
                durability[i] -= weight[start];
                int broken = 0;
                if(durability[start] <= 0){
                    broken++;
                }
                if(durability[i] <= 0){
                    broken++;
                }
                egg(start+1, brokenCnt+broken);
                durability[start] += weight[i];
                durability[i] += weight[start];
            }
        }
    }
}
