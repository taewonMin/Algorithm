package problem.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쇠막대기
public class Stack_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int stack = 0;
        char prev = '(';
        char[] braces = br.readLine().toCharArray();
        for(char brace : braces){
            if(brace == '('){
                stack++;
            }else{
                if(prev == '('){    // 레이저
                    stack--;
                    sum += stack;
                }else{
                    stack--;
                    sum++;
                }
            }
            prev = brace;
        }

        System.out.println(sum);

        br.close();
    }
}
