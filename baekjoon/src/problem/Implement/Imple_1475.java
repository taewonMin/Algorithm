
package problem.Implement;

import java.util.Scanner;

// 방 번호
public class Imple_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[10];
        for(char c : sc.nextLine().toCharArray()){
            int number = c-'0';
            if(number == 6 && numbers[6] > numbers[9]){
                numbers[9]++;
            }else if(number == 9 && numbers[9] > numbers[6]){
                numbers[6]++;
            }else{
                numbers[number]++;
            }
        }

        int max = 0;
        for(int i : numbers){
            if(max < i){
                max = i;
            }
        }

        System.out.println(max);

        sc.close();
    }
}
