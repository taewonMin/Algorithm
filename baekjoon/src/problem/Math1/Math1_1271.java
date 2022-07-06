package problem.Math1;

import java.util.Scanner;


// 엄청난 부자2
public class Math1_1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(n/m);
        System.out.println(n%m);

        sc.close();
    }
}
