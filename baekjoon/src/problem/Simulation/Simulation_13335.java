package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 트럭
public class Simulation_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int time = 1;
        int next = 1;
        int totalWeight = trucks[0];
        List<Truck> bridge = new ArrayList<>();
        bridge.add(new Truck(trucks[0], 1));

        while(!bridge.isEmpty()){
            // 현재 올라와있는 트럭들 한 단계씩 전진
            for(int i=0; i<bridge.size(); i++){
                bridge.get(i).time++;
            }
            // 도착한 트럭 제거
            if(bridge.get(0).time > w){
                totalWeight -= bridge.remove(0).weight;
            }
            // 다음 트럭이 올라갈 수 있는지 체크
            if(next < n && totalWeight + trucks[next] <= L){
                bridge.add(new Truck(trucks[next], 1));
                totalWeight += trucks[next++];
            }
            time++;
        }

        System.out.println(time);
        
        br.close();
    }

    static class Truck{
        int weight;
        int time;

        Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
}
