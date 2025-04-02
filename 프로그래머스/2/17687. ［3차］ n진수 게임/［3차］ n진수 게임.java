import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for(int i = 0; answer.toString().length() < t; i++) {
            String s = convert(n, i);
            for(char c : s.toCharArray()) {
                if(cnt % m == p - 1)
                    answer.append(c);
                if(answer.toString().length() == t) break;
                cnt++;
            }
        }
        return answer.toString();
    }
    
    private String convert(int n, int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) sb.append(0);
        while(num > 0) {
            if(num % n < 10)
                sb.append(num % n);
            else
                sb.append((char)(num % n - 10 + 'A'));
            num /= n;
        }
        return sb.reverse().toString();
    }
}