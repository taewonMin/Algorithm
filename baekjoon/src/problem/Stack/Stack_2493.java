package problem.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

// 탑
public class Stack_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>(); // 타워 순서
        for(int i=0; i<towers.length; i++){
            while(!stack.isEmpty() && towers[stack.peek()] < towers[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        for(int i : result){
            bw.append(i+" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
