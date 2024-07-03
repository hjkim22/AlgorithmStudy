import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> uniqueChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
           }
        }
        
        Collections.sort(uniqueChars);
        
        StringBuilder answer = new StringBuilder();
        for (char c : uniqueChars) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}