class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int pointer1 = 0, pointer2 = 0;
        int len1 = cards1.length, len2 = cards2.length;

        for (String word : goal) {
            if (pointer1 < len1 && cards1[pointer1].equals(word)) {
                pointer1++;
            } else if (pointer2 < len2 && cards2[pointer2].equals(word)) {
                pointer2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}