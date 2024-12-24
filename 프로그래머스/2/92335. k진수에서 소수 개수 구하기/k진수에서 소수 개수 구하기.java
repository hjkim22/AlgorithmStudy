import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        String kNumber = Integer.toString(n, k);
        String[] arr = kNumber.split("0");
        int answer = 0;

        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }

            long num = Long.parseLong(s);

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }
    
    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}