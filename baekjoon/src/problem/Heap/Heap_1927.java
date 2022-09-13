package problem.Heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 최소 힙
public class Heap_1927 {
    public static int[] heap;
    public static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        heap = new int[N+1];
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){   // 삭제
                bw.write(pop()+"\n");
            }else{  // 삽입
                push(x);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void push(int x){
        heap[++size] = x;
        int idx = size;
        while(idx > 1 && heap[idx/2] > heap[idx]){
            int temp = heap[idx];
            heap[idx] = heap[idx/2];
            heap[idx/2] = temp;
            idx /= 2;
        }
    }

    public static int pop(){
        int num = heap[1];
        if(size > 0){
            heap[1] = heap[size];
            heap[size] = 0;
            size--;

            int idx = 1;
            while(idx*2 <= size){
                int left = idx*2, right = idx*2+1;
                int next = left;
                if(right<=size && heap[right] < heap[left]){
                    next = right;
                }
                if(heap[idx] <= heap[next]){
                    break;
                }
                int temp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = temp;
                idx = next;
            }
        }
        return num;
    }
}
