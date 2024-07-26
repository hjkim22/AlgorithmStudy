class Solution {
    public int[] solution(long n) {

        String numStr = Long.toString(n);
        
        int[] answer = new int[numStr.length()];
        
        int idx = 0;
        
        for (int i = numStr.length() - 1; i >= 0; i--) {
            answer[idx++] = Character.getNumericValue(numStr.charAt(i));
        }
        
        return answer;
    }
}