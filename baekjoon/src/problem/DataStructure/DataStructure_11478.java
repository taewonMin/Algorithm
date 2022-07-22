package problem.DataStructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 서로 다른 부분 문자열의 개수
class DataStructure_11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> check = new HashSet<>();
        String str = sc.nextLine();
        for(int i=1; i<str.length(); i++){
            for(int j=0; j<=str.length()-i; j++){
                check.add(str.substring(j, j+i));
            }
        }

        System.out.println(check.size()+1);

        sc.close();
    }
}