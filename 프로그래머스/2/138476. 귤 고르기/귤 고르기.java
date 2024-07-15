import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCountMap = new HashMap<>();
        for (int size : tangerine) {
            sizeCountMap.put(size, sizeCountMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(sizeCountMap.values());
        Collections.sort(countList, Collections.reverseOrder());

        int selectedCount = 0;
        int kindCount = 0;

        for (int count : countList) {
            selectedCount += count;
            kindCount++;
            if (selectedCount >= k) {
                break;
            }
        }

        return kindCount;
    }
}
