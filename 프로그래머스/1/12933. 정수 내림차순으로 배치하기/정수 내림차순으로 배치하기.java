import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public long solution(long n) {
        String numberString = Long.toString(n);
        
        Character[] charArray = new Character[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            charArray[i] = numberString.charAt(i);
        }
        
        Arrays.sort(charArray, Collections.reverseOrder());
        
        StringBuilder sortedString = new StringBuilder(charArray.length);
        for (char c : charArray) {
            sortedString.append(c);
        }
        
        return Long.parseLong(sortedString.toString());
    }
}