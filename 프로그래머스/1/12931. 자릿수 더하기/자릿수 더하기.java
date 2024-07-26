import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String intNum = Integer.toString(n);
        
        char[] charArr = intNum.toCharArray();
        
        for (char c : charArr) {
            answer += Character.getNumericValue(c);
        }
        
        return answer;
    }
}