import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] rank = priorities.clone();
        Arrays.sort(rank);
        Deque <Deque<Integer>> d = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            Deque <Integer> temp = new ArrayDeque<>();
            temp.add(priorities[i]);
            temp.add(i);
            d.add(temp);
        }
        
        for(int i = rank.length - 1; i >= 0; i--) {
            while(d.peek().peek() != rank[i])
                d.addLast(d.remove());
            if(d.peek().peekLast() == location) {
                answer = rank.length - i;
                break;
            }
            d.remove();
        }
        return answer;
    }
}