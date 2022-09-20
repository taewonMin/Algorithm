package problem.Implement;

import java.util.Scanner;

// 팰린드롬인지 확인하기
public class Imple_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int st = 0;
        int en = word.length()-1;
        int isPalindrome = 1;
        while(st<en){
            if(word.charAt(st++) != word.charAt(en--)){
                isPalindrome = 0;
                break;
            }
        }

        System.out.println(isPalindrome);

        sc.close();
    }
}
