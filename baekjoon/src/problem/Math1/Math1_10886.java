package problem.Math1;

import java.util.Scanner;

// 0 = not cute / 1 = cute
public class Math1_10886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] check = new int[2];
        for(int i=0; i<N; i++){
            check[sc.nextInt()]++;
            sc.nextLine();
        }
        
        if(check[0] > check[1]){
            System.out.println("Junhee is not cute!");
        }else{
            System.out.println("Junhee is cute!");
        }

        sc.close();
    }
}
