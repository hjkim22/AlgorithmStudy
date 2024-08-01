class Solution {
    public int[] solution(int n) {
        int oddCnt = (n + 1) / 2;
        int[] answer = new int[oddCnt];
        
        int idx = 0;
        for (int i = 1; i <= n; i += 2) {
            answer[idx++] = i;
        }
        return answer;
    }
}