package problem.Math1;

import java.util.Scanner;

// 다면체
public class Math1_10569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int V = sc.nextInt();
            int E = sc.nextInt();
            System.out.println(2+E-V);
            sc.nextLine();
        }

        sc.close();
    }
}
