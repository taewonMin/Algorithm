package problem.BackTracking;

import java.util.Scanner;
import java.util.StringTokenizer;

// 부분수열의 합
public class BackTracking_1182 {
    public static int N, S;
    public static int cnt = 0;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        sc.nextLine();

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);

        if(S==0){
            System.out.println(cnt-1);
        }else{
            System.out.println(cnt);
        }

        sc.close();
    }

    public static void backTracking(int k, int sum){
        if(k==N){
            if(sum==S){
                cnt++;
            }
            return;
        }
        backTracking(k+1, sum+arr[k]); // 포함
        backTracking(k+1, sum); // 미포함
    }
}
