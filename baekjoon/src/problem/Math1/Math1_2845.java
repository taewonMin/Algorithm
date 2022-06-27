package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 파티가 끝나고 난 뒤
public class Math1_2845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt() * sc.nextInt();
        sc.nextLine();
        int[] news = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i : news){
            System.out.print(i - total+" ");
        }

        sc.close();
    }
}
