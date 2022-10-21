package kakao.internship_2020;

// 수식 최대화
public class Prob_67257 {
    long answer = 0;
    char[] operations = {'-','+','*'};
    boolean[] selected = new boolean[3];
    public long solution(String expression) {
        backTracking(expression, 0, "");
        return answer;
    }
    
    public void backTracking(String exp, int k, String order){
        if(k==3){
            answer = Math.max(answer, Math.abs(seperate(exp, order)));
            return;
        }
        
        for(int i=0; i<3; i++){
            if(selected[i]==false){
                selected[i]=true;
                backTracking(exp, k+1, order+operations[i]);
                selected[i]=false;
            }
        }
    }
    
    
    public long seperate(String str, String operation){
        if(operation.equals("") || str.charAt(0)=='-'){
            return Long.parseLong(str);
        }
        String oper = String.valueOf(operation.charAt(0));
        String[] subStr = str.split("\\"+oper);
        long result = 0;
        if(subStr.length==1){
            result = seperate(str, operation.substring(1));
        }else{
            for(int i=1; i<subStr.length; i++){
                long num1 = seperate(subStr[i-1], operation.substring(1));
                long num2 = seperate(subStr[i], operation.substring(1));
                switch(oper){
                    case "-":
                        subStr[i] = String.valueOf(num1-num2);
                        break;
                    case "+":
                        subStr[i] = String.valueOf(num1+num2);
                        break;
                    case "*":
                        subStr[i] = String.valueOf(num1*num2);
                        break;
                }
            }
            result = Long.parseLong(subStr[subStr.length-1]);
        }
        return result;
    }
}
