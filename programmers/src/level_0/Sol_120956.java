package level_0;

// 옹알이
public class Sol_120956 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] impossibleWords = {"ayaaya","yeye","woowoo","mama"};
        String[] words = {"aya","ye","woo","ma"};

        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];
            for(String iw : impossibleWords){
                str = str.replace(iw, "*");
            }
            for(String w : words){
                str = str.replace(w, "");
            }
            if(str.length()==0) answer++;
        }

        return answer;
    }


    // 방법 2
    public int solution2(String[] babbling) {
        int answer = 0;

        for(int i=0; i<babbling.length; i++){
            if(checkWord(babbling[i])){
                answer++;
            }
        }

        return answer;
    }

    public static boolean checkWord(String str){
        String[] word = {"aya","ye","woo","ma"};
        int length = str.length();
        int prevIdx = -1;
        while(length > 0){
            for(int i=0; i<word.length; i++){
                if(i==prevIdx) continue;
                String temp = str.replaceFirst(word[i], "");
                if(!str.equals(temp)){
                    str = temp;
                    prevIdx = i;
                    break;
                }
            }
            if(str.length() == length){
                return false;
            }
            length = str.length();
        }
        return true;
    }
}