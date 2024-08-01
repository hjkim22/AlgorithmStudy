class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder(my_string);
        char upperCaseChar = alp.toUpperCase().charAt(0);
        
        for (int i = 0; i < my_string.length(); i++) {
            if (sb.charAt(i) == alp.charAt(0)) {
                sb.setCharAt(i, upperCaseChar);
            }
        }
        return sb.toString();
    }
}