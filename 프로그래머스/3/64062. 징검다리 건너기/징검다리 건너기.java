import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int len = stones.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; ++i){
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && stones[dq.peekLast()] < stones[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if(i >= k - 1) {
                max = Math.min(max, stones[dq.peekFirst()]);
            }
        }
        
        return max;
    }
}