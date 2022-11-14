package problem.Implement;

import java.util.Scanner;

// 치킨 두 마리(...)
public class Imple_14489{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.nextLine();
        int price = sc.nextInt();
        int sum = num1+num2;
        if(sum >= price*2){
            System.out.println(sum - price*2);
        }else{
            System.out.println(sum);
        }

        sc.close();
    }
}

