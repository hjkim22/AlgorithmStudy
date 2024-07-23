import java.util.HashMap;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int count = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isMatch = true;
            for (String key : wantMap.keySet()) {
                if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    isMatch = false;
                    break;
                }
            }
            
            if (isMatch) {
                count++;
            }
        }
        
        return count;
    }
}