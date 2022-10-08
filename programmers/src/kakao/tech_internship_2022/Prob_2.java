package kakao.tech_internship_2022;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
public class Prob_2 {
    // 큐 이용
    public int solution1(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        while(sum1!=sum2){
            if(answer == queue1.length*4){
                return -1;
            }
            if(sum1 < sum2){
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }else if(sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            }
            answer++;
        }

        return answer;
    }

    // 투 포인터
    public int solution2(int[] queue1, int[] queue2) {
        int answer = 0;

        int n = queue1.length;
        int[] arr = new int[n*2];
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<n; i++){
            arr[i] = queue1[i];
            sum1 += arr[i];
        }
        for(int i=0; i<n; i++){
            arr[n+i] = queue2[i];
            sum2 += queue2[i];
        }

        int p1 = 0;
        int p2 = n;
        while(sum1!=sum2){
            if(answer == n*4) return -1;
            if(sum1 > sum2){
                sum2 += arr[p1];
                sum1 -= arr[p1];
                p1++;
                p1 %= 2*n;
            }else if(sum1 < sum2){
                sum1 += arr[p2];
                sum2 -= arr[p2];
                p2++;
                p2 %= 2*n;
            }
            answer++;
        }

        return answer;
    }
}