import java.util.*;

public class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] result = new int[length];
        
        for (long idx = left; idx <= right; idx++) {
            int row = (int) (idx / n);
            int col = (int) (idx % n);
            result[(int) (idx - left)] = Math.max(row, col) + 1;
        }
        
        return result;
    }
}
