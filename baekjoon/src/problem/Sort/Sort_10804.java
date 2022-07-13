package problem.Sort;

import java.util.Scanner;

// 카드 역배치
public class Sort_10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] card = new int[21];
        for(int i=1; i<21; i++){
            card[i] = i;
        }

        for(int i=0; i<10; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            while(a<b){
                int temp = card[a];
                card[a] = card[b];
                card[b] = temp;
                a++;
                b--;
            }
        }

        for(int i=1; i<card.length; i++){
            System.out.print(card[i]+" ");
        }

        sc.close();
    }
}
