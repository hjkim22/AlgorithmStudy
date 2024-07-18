public class Solution {
    public int solution(int N, int A, int B) {
        int round = 0;

        if (A > B) {
            int temp = A;
            A = B;
            B = temp;
        }

        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            round++;
        }

        return round;
    }
}