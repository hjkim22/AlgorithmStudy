import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[] preSumPlus = new long[sequence.length + 1];  //+부터 시작하는
        long[] preSumMinus = new long[sequence.length + 1]; //-부터 시작하는

        long pm = 1;
        long plusSum = 0;
        long minusSum = 0;
        for (int i = 0; i < sequence.length; i++) {
            plusSum += sequence[i] * pm;
            preSumPlus[i + 1] = plusSum;
            pm *= -1;
            minusSum += sequence[i] * pm;
            preSumMinus[i + 1] = minusSum;
        }

        long result = Long.MIN_VALUE;
        result = getResult(sequence, preSumPlus, result);
        result = getResult(sequence, preSumMinus, result);
        return result;
    }

    public long getResult(int[] sequence, long[] preSum, long result) {
        int lo = 0;
        int hi = 1;
        while(hi <= sequence.length) {
            long sum = preSum[hi] - preSum[lo];
            if (sum >= 0) {
                result = Math.max(result, sum);
                hi++;
            }
            else {
                lo = hi;
                hi++;
            }
        }
        return result;
    }
}