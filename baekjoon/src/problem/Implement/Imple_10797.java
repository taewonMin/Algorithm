package problem.Implement;

import java.util.Arrays;
import java.util.Scanner;

// 10부제
public class Imple_10797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        sc.nextLine();
        int[] car = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        for(int num : car){
            if(num==day){
                cnt++;
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}
