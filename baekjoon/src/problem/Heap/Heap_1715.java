package problem.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기
public class Heap_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(queue.size() > 1){
            int temp = queue.poll() + queue.poll();
            queue.add(temp);
            sum += temp;
        }

        System.out.println(sum);

        br.close();
    }
}
