public class Solution {
    public int solution(int n) {
        int ans = 0;
        for(char c : Integer.toBinaryString(n).toCharArray())
            if(c == '1')
                ans++;
        return ans;
    }
}