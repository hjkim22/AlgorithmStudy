import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        left.put(topping[0], 1);
        for(int i=1; i<topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i], 0)+1);
        }
        
        if(left.size()==right.size()) answer = 1;
        
        for(int i=1; i<topping.length; i++){
            if(right.get(topping[i])>1){
                right.replace(topping[i], right.get(topping[i])-1);
            }
            else right.remove(topping[i]);

            left.put(topping[i], left.getOrDefault(topping[i], 0)+1);

            
            if(left.size() < right.size()){
                continue;
            }    
            else if(left.size()==right.size()){
                answer++;
            }
            else break;
        }
        
        return answer;
    }
}