package problem.Math1;

import java.math.BigInteger;
import java.util.Scanner;

// 엄청난 부자2
public class Math1_1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));

        sc.close();
    }
}
