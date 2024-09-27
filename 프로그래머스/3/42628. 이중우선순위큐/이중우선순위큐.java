import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(String s : operations) {
            int N = Integer.parseInt(s.substring(2));
            if(s.charAt(0) == 'I') {
                min.add(N);
                max.add(N);
            }
            else {
                if(N == -1 && !min.isEmpty()) {
                    min.poll();
                    max.clear();
                    max.addAll(min);
                }
                else if(N == 1 && !max.isEmpty()) {
                    max.poll();
                    min.clear();
                    min.addAll(max);
                }
            }
        }
        if(!min.isEmpty()) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}