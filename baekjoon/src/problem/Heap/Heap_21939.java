package problem.Heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

// 문제 추천 시스템 Version 1
public class Heap_21939 {
    static class Problem implements Comparable<Problem> {
        int num;
        int level;

        Problem(int num, int level){
            this.num = num;
            this.level = level;
        }
        
        @Override
        public int compareTo(Problem o) {
            int order = this.level - o.level;
            if(order==0){
                return this.num - o.num;
            }
            return order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] problems = new int[100001];
        PriorityQueue<Problem> maxHeap = new PriorityQueue<>((o1,o2) -> {
            if(o1.level == o2.level){
                return o2.num - o1.num;
            }
            return o2.level - o1.level;
        });
        PriorityQueue<Problem> minHeap = new PriorityQueue<>(((o1, o2) -> {
            if(o1.level == o2.level){
                return o1.num - o2.num;
            }
            return o1.level - o2.level;
        }));
        for(int i=0; i<N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Problem prob = new Problem(input[0], input[1]);
            maxHeap.add(prob);
            minHeap.add(prob);
            problems[input[0]] = input[1];
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "add":
                    int num = Integer.parseInt(input[1]);
                    int level = Integer.parseInt(input[2]);
                    Problem prob = new Problem(num, level);
                    maxHeap.add(prob);
                    minHeap.add(prob);
                    problems[num] = level;
                    break;
                case "recommend":
                    PriorityQueue<Problem> heap = input[1].equals("1") ? maxHeap : minHeap;
                    while(problems[heap.peek().num]!=heap.peek().level){
                        heap.poll();
                    }
                    bw.write(heap.peek().num+"\n");
                    break;
                case "solved":
                    problems[Integer.parseInt(input[1])] = 0;
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
