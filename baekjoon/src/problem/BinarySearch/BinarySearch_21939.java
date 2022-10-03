package problem.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 문제 추천 시스템 Version 1
public class BinarySearch_21939 {
    public static List<Problem> list = new ArrayList<>();
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
        for(int i=0; i<N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Problem(input[0], input[1]));
            problems[input[0]] = input[1];
        }
        list.sort(null);

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "add":
                    int num = Integer.parseInt(input[1]);
                    int level = Integer.parseInt(input[2]);
                    list.add(binarySearch(num, level), new Problem(num, level));
                    problems[num] = level;
                    break;
                case "recommend":
                    if(input[1].equals("1")){
                        bw.write(list.get(list.size()-1).num+"\n");
                    }else{
                        bw.write(list.get(0).num+"\n");
                    }
                    break;
                case "solved":
                    num = Integer.parseInt(input[1]);
                    list.remove(binarySearch(num, problems[num]));
                    problems[num] = 0;
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int num, int level){
        int start = 0;
        int end = list.size()-1;

        while(start <= end){
            int mid = (end+start)/2;
            Problem prob = list.get(mid);
            if(prob.level < level){
                start = mid+1;
            }else if(prob.level > level){
                end = mid-1;
            }else{
                if(prob.num < num){
                    start = mid+1;
                }else if(prob.num > num){
                    end = mid-1;
                }else{
                    return mid;
                }
            }
        }
        return start;
    }
}
