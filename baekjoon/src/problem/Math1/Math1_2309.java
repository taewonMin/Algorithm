package problem.Math1;

import java.util.Arrays;
import java.util.Scanner;

// 일곱 난쟁이
public class Math1_2309 {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        search(sum-100);

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                System.out.println(arr[i]);
            }
        }

        sc.close();
    }

    public static void search(int remain){
        for(int i=arr.length-1; i>=0; i--){
            for(int j=i-1; j>=0; j--){
                int sum = arr[i]+arr[j];
                if(sum == remain){
                    arr[i]=0;
                    arr[j]=0;
                    return;
                }else if(sum < remain){
                    break;
                }
            }
        }
    }
}
