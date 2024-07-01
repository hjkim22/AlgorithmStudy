import java.util.*;

class Solution {
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            int start = timeToMinutes(book_time[i][0]);
            int end = timeToMinutes(book_time[i][1]) + 10;
            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }

        return pq.size();
    }
}
