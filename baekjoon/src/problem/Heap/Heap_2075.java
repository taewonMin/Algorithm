package problem.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// N번째 큰 수
public class Heap_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                queue.offer(Integer.parseInt(input[j]));
                if(queue.size() > N){
                    queue.poll();
                }
            }
        }
        System.out.println(queue.peek());

        br.close();
    }
}
