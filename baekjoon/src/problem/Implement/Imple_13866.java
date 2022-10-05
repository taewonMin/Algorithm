package problem.Implement;

import java.util.Arrays;
import java.util.Scanner;

// 팀 나누기
public class Imple_13866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] level = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Math.abs(level[0]+level[3]-level[1]-level[2]));

        sc.close();
    }
}
