package problem.Conditionals;

import java.util.Scanner;

public class Conditionals_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dice = new int[7];
        int result = 0;
        int max = 0;
        for(int i=0; i<3; i++){
            dice[sc.nextInt()]++;
        }
        for(int i=0; i<dice.length; i++){
            if(dice[i]==3){
                result = 10000 + i*1000;
                break;
            }else if(dice[i]==2){
                result = 1000 + i*100;
                break;   
            }else if(dice[i]==1 && max < i){
                max = i;
            }
        }

        if(result == 0){
            result = max * 100;
        }

        System.out.println(result);

        sc.close();
    }
}
