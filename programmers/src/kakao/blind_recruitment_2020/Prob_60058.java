package kakao.blind_recruitment_2020;

// 괄호 변환
public class Prob_60058 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("(()())()"));
    }
}

class Solution {
    public String solution(String p) {
        return seperate(p.toCharArray());
    }
    
    public String seperate(char[] str){
        if(str.length==0) return "";
        String u = "";
        int leftCnt = 0;
        int rightCnt = 0;
        for(int i=0; i<str.length; i++){
            if(str[i]=='('){
                leftCnt++;
            }else{
                rightCnt++;
            }
            u += str[i];
            if(leftCnt==rightCnt) break;
        }
        
        String v = "";
        for(int i=u.length(); i<str.length; i++){
            v += str[i];
        }
        if(u.charAt(0)==')'){
            String reverse = "";
            for(int i=1; i<u.length()-1; i++){
                reverse += u.charAt(i)=='(' ? ')' : '(';
            }
            return "("+seperate(v.toCharArray())+")"+reverse;
        }else{
            return u+seperate(v.toCharArray());
        }
    }
}
