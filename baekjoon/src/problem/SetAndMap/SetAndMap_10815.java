package problem.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 숫자 카드
public class SetAndMap_10815 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        
        // solution1();
        solution2();

        br.close();
        bw.flush();
        bw.close();
    }

    // Map 자료구조 이용
    public static void solution1() throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Boolean> numberCard = new HashMap<>();
        for(int num : input){
            numberCard.put(num, true);
        }
        int M = Integer.parseInt(br.readLine());
        int[] checkCard = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int card : checkCard){
            if(numberCard.get(card)!=null){
                bw.write(1+" ");
            }else{
                bw.write(0+" ");
            }
        }
    }

    // 이분 탐색
    public static void solution2() throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] numberCard = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numberCard);
        
        int M = Integer.parseInt(br.readLine());
        int[] checkNumbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int num : checkNumbers){
            bw.write(binarySearch(numberCard, num)+" ");
        }
    }

    public static int binarySearch(int[] numberCard, int target){
        int lo = 0;
        int hi = numberCard.length-1;
        int mid = (lo+hi)/2;
        while(lo<=hi){
            if(numberCard[mid]==target){
                return 1;
            }else if(numberCard[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            mid = (lo+hi)/2;
        }
        return 0;
    }
}