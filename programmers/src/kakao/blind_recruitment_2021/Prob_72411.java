package kakao.blind_recruitment_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 메뉴 리뉴얼
public class Prob_72411 {
    String[] orderArr;
    Map<String, Integer> cntMap = new HashMap<>();
    int[] maxSize;
    int nextIdx = 1;
    public String[] solution(String[] orders, int[] course) {
        
        orderArr = orders;
        maxSize = new int[course[course.length-1]+1];
        for(String order : orderArr){
            for(int i=0; i<course.length; i++){
                if(order.length() >= course[i]){
                    char[] charArr = order.toCharArray();
                    Arrays.sort(charArr);
                    combination(charArr, course[i], 0, "");
                }
            }
            nextIdx++;
        }
        
        List<String> result = new ArrayList<>();
        cntMap.forEach((key, value) -> {
            if(maxSize[key.length()] == value){
                result.add(key);
            }
        });
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public void combination(char[] charArr, int k, int idx, String select){
        if(k==0){
            if(cntMap.containsKey(select)) return;
            search(select);
            return;
        }
        
        for(int i=idx; i<charArr.length; i++){
            combination(charArr, k-1, i+1, select+charArr[i]);
        }
    }
    
    public void search(String str){
        int cnt = 1;
        for(int i=nextIdx; i<orderArr.length; i++){
            boolean isContain = true;
            for(int j=0; j<str.length(); j++){
                if(orderArr[i].contains(String.valueOf(str.charAt(j)))==false){
                    isContain = false;
                    break;
                }
            }
            if(isContain) cnt++;
        }
        cntMap.put(str, cnt);
        if(cnt > 1){
            maxSize[str.length()] = Math.max(maxSize[str.length()], cnt);
        }
    }
}