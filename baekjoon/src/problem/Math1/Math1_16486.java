package problem.Math1;

import java.util.Scanner;

// 운동장 한 바퀴
public class Math1_16486 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d1 = sc.nextInt();
        sc.nextLine();
        int d2 = sc.nextInt();
        System.out.println(2*3.141592*d2 + 2*d1);

        sc.close();
    }
}
