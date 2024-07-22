public class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            int remainder = n % 3;
            n = (n - 1) / 3;
            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}