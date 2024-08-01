class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int value : array) {
            if (value > height) {
                answer++;
            }
        }
        return answer;
    }
}