package problem.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 좋은 단어
public class Stack_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++){
            Stack<Character> stack = new Stack<>();
            for(char c : br.readLine().toCharArray()){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

            if(stack.isEmpty()){
                cnt++;
            }
        }

        System.out.println(cnt);
        
        br.close();
    }
}
