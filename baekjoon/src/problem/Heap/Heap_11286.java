package problem.Heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 절댓값 힙
public class Heap_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Number> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(queue.isEmpty()){
                    bw.write(0+"\n");
                }else{
                    bw.write(queue.poll().num+"\n");
                }
            }else{
                queue.offer(new Number(x));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Number implements Comparable<Number> {
        int num;

        public Number(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Number number) {
            if(Math.abs(this.num)==Math.abs(number.num)){
                return this.num < number.num ? -1 : 1;
            }else{
                return Math.abs(this.num) < Math.abs(number.num) ? -1 : 1;
            }
        }
    }
}
