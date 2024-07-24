import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : scoville) {
            minHeap.add(num);
        }
        
        int mixCount = 0;
        
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            
            int newScoville = first + (second * 2);
            minHeap.add(newScoville);
            
            mixCount++;
        }
        
        if (minHeap.peek() >= K) {
            return mixCount;
        } else {
            return -1;
        }
    }
}
