import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = Integer.MAX_VALUE;
        if(s.length()==1) answer = 1;
        
        for(int i=1; i<s.length(); i++){
            int cut = i;
            
            int count = 0;
            String cutStr = s.substring(0, cut);
            String str = ""; 
            int length = 0;
            
            for(int j=0; j<=s.length()-cut; j+=cut){
                if(cutStr.equals(s.substring(j, j+cut))) {
                    count++;
                }
                
                else {
                    if(1<count) str+=(count+cutStr);
                    else str+=cutStr;
                    
                    cutStr = s.substring(j, j+cut);
                    count=1;
                }
            }
            
            if(1<count) str+=(count+cutStr);
            else str+=cutStr;
            
            if(s.length()%cut==0) length = str.length();
            else length = str.length() + (s.length()%cut);
            
            answer = Math.min(answer, length);
        }
        
        
        return answer;
    }
}