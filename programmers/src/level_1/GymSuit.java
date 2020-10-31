package level_1;

public class GymSuit {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = n-lost.length;	//呪穣聖 級聖 呪 赤澗 俳持 呪
	        // 籍嬢獄掲走幻 森搾差赤澗紫寓 薦須
	        for(int i=0; i<lost.length; i++){	
	        	for(int j=0; j<reserve.length; j++){
	        		if(lost[i]==reserve[j]){
	        			lost[i] = -1;
	        			reserve[j] = -1;
	        			answer++;
	        			break;
	        		}
	        	}
	        }
	        
	        for(int i=0; i<lost.length; i++){
	        	for(int j=0; j<reserve.length; j++){
	        		if(lost[i]==reserve[j]-1 || lost[i]==reserve[j]+1){
	        			reserve[j] = -1;
	        			answer++;
	        			break;
	        		}
	        	}
	        }
	        
	        
	// 砺什闘追戚什 7腰 訊 照鞠澗走 硝 呪亜 蒸陥たたたたたたた
//	      boolean[] lostStd = new boolean[n];	// 籍嬢獄鍵 俳持 端滴 壕伸
	        
//	      for(int i=0; i<lost.length; i++){	// 籍嬢獄携生檎 true
//	      	lostStd[lost[i]-1] = true;
//	      }
	        
//	        for(int i=0; i<reserve.length; i++){
//	        	if(lostStd[reserve[i]-1]==true){	// 食歳聖 亜走壱 赤澗 俳持戚 籍嬢獄掲生檎
//	        		lostStd[reserve[i]-1] = false;
//	        	}else if(reserve[i]!=1 && lostStd[reserve[i]-2]==true){	// 食歳聖 亜走壱 赤澗 俳持税 蒋腰硲	
//	        		lostStd[reserve[i]-2] = false;
//	        	}else if(reserve[i]!=n && lostStd[reserve[i]]==true){	// 食歳聖 亜走壱 赤澗 俳持税 急腰硲
//	        		lostStd[reserve[i]] = false;
//	        	}else{
//	        		continue;
//	        	}
//	        	answer++;
//	        }
	        
	        return answer;
	    }
	}
}
