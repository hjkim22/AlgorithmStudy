class Solution {
    public int solution(int[] num_list) {
        StringBuilder evenNum = new StringBuilder();
        StringBuilder oddNum = new StringBuilder();
        
        for (int num : num_list) {
            if (num % 2 == 0) {
                evenNum.append(num);
            } else {
                oddNum.append(num);
            }
        }
        
        int evenSum = Integer.parseInt(evenNum.toString());
        int oddSum = Integer.parseInt(oddNum.toString());
        
        return evenSum + oddSum;
    }
}