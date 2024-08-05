class Solution {
    public String solution(String my_string, int k) {
        // StringBuilder 사용
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < k; i++) {
        //     sb.append(my_string);
        // }
        // return sb.toString();
        
        // String a = "";
        // for (int i = 0; i < k; i++) {
        //     a += my_string;
        // }
        // return a;
        
        return my_string.repeat(k);
    }
}