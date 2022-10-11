package problem.Implement;

import java.util.Scanner;

// 파일 옮기기
public class Imple_11943 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int appleA = sc.nextInt();
        int orangeA = sc.nextInt();
        sc.nextLine();
        int appleB = sc.nextInt();
        int orangeB = sc.nextInt();

        System.out.println(Math.min(appleA+orangeB, orangeA+appleB));

        sc.close();
    }
}
