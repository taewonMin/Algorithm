package problem.Implement;

import java.util.Scanner;

// 집 주소
public class Imple_1284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String N = sc.nextLine();
            if(N.equals("0")) break;

            int width = 1;
            for(int i=0; i<N.length(); i++){
                switch(N.charAt(i)){
                    case '1':
                        width += 2;
                        break;
                    case '0':
                        width += 4;
                        break;
                    default:
                        width += 3;
                }
                width++;
            }
            System.out.println(width);
        }

        sc.close();
    }
}
