package problem.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제
public class Queue_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();
        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        ArrayList<String> result = new ArrayList<>();
        int cnt = 1;
        while(!queue.isEmpty()){
            if(cnt == K){
                result.add(String.valueOf(queue.poll()));
                cnt = 1;
            }else{
                queue.offer(queue.poll());
                cnt++;
            }
        }

        System.out.println("<"+String.join(", ", result)+">");

        sc.close();
    }
}
