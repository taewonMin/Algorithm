package category.Stack;

import java.util.Stack;

// 올바른 괄호
public class Sol_12909 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("(())()"));
    }
}

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}