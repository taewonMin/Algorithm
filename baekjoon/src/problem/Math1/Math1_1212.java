package problem.Math1;

import java.util.Scanner;

// 8진수 2진수
public class Math1_1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        String[] numbers = {"000","001","010","011","100","101","110","111"};
        String number = sc.nextLine();
        for(int i=0; i<number.length(); i++){
            sb.append(numbers[number.charAt(i) - '0']);
        }

        if(number.equals("0")){
            System.out.println(0);
        }else{
            while(sb.charAt(0)=='0'){
                sb = new StringBuilder(sb.substring(1));
            }
            System.out.println(sb);
        }

        sc.close();
    }
}
