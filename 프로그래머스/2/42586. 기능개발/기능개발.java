import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] daysToComplete = new int[n];
        
        for (int i = 0; i < n; i++) {
            int remainingWork = 100 - progresses[i];
            daysToComplete[i] = (int) Math.ceil((double) remainingWork / speeds[i]);
        }

        List<Integer> result = new ArrayList<>();
        int currentDeployDay = daysToComplete[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (daysToComplete[i] <= currentDeployDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                currentDeployDay = daysToComplete[i];
            }
        }
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }
}