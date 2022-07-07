package problem.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

// 에디터
public class DataStructure_1406 {
    public static void main(String[] args) throws IOException {
        solution2();
    }

    // ListIterator
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> list = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        ListIterator<String> it = list.listIterator();

        while(it.hasNext()){
            it.next();
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String input = br.readLine();
            switch(input){
                case "L":
                    if(it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case "D":
                    if(it.hasNext()){
                        it.next();
                    }
                    break;
                case "B":
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                    break;
                default:
                    it.add(input.split(" ")[1]);
            }
        }

        System.out.println(String.join("", list));

        br.close();
    }

    // Stack
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        
        for(String str : br.readLine().split("")){
            leftStack.push(str);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String input = br.readLine();
            switch(input){
                case "L":
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                default:
                    leftStack.push(input.split(" ")[1]);
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);

        br.close();
    }
}