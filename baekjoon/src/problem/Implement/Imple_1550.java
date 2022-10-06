package problem.Implement;

import java.util.Scanner;

// 16진수
public class Imple_1550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String str = sc.nextLine();
        // int k = str.length()-1;
        // int sum = 0;
        // for(char c : str.toCharArray()){
        //     int temp = c-'0';
        //     if(temp > 9){  // 문자
        //         temp = (10+(c-'A'));
        //     }

        //     for(int i=0; i<k; i++){
        //         temp *= 16;
        //     }
        //     sum += temp;
        //     k--;
        // }

        System.out.println(Integer.parseInt(sc.nextLine(), 16));

        sc.close();
    }
}
