package problem.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class Stack_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int cnt = 1;
        char prev = '0';
        char[] braces = br.readLine().toCharArray();
        for(char brace : braces){
            if(brace == '('){
                stack.push(brace);
                cnt *= 2;
            }else if(brace == '['){
                stack.push(brace);
                cnt *= 3;
            }else if(brace == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    result = 0;
                    break;
                }else if(prev == '('){  // 바로 이전 괄호와 쌍을 이룰 경우에만
                    result += cnt;
                }
                cnt /= 2;
            }else if(brace == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    result = 0;
                    break;
                }else if(prev == '['){
                    result += cnt;
                }
                cnt /= 3;
            }
            prev = brace;
        }

        if(!stack.isEmpty()){
            result = 0;
        }
        System.out.println(result);

        br.close();
    }
}
