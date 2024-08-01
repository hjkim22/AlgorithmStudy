class Solution {
    public int[] solution(int[] array) {
        int max = array[0];
        int maxIdx = 0;
        int[] answer = new int[2];
        
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIdx = i;
            }
        }
        answer[0] = max;
        answer[1] = maxIdx;
        
        return answer;
    }
}