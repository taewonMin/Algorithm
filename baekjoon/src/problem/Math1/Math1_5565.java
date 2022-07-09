package problem.Math1;

import java.util.Scanner;

// 영수증
public class Math1_5565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();
        for(int i=0; i<9; i++){
            price -= sc.nextInt();
        }

        System.out.println(price);

        sc.close();
    }
}
