import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String s = String.valueOf(storey);
        int[] num = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            num[i] = s.charAt(i)-'0';
        }
        
        //5555 -> 5560 -> 5600 -> 6000 -> 10000 ->0
        for(int i=s.length()-1; i>=0; i--){
            int idx = num[i];
            
            if(idx<=4){ //내리는게 최소
                answer += idx;
            }
            else if(idx>=6){ //올리는게 최소
                idx = 10-idx;
                answer += idx;
                if(i>0){
                    num[i-1]++;
                }
                else{
                    answer += 1; //0층으로 이동
                    break;
                }
            }
            else{ //5인 경우
                if(i>0){
                    if(num[i-1]>=5){ //올리는게 최소
                        answer += 5;
                        num[i-1]++;
                    }
                    else{ //내리는게 최소
                        answer += 5;
                    }
                }
                else{
                    answer += 5;
                    break;
                }
            }
        }
        return answer;
    }
}