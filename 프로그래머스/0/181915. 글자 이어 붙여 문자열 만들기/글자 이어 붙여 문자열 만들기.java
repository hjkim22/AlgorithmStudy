class Solution {
    public String solution(String my_string, int[] index_list) {
        // 기본 구현
//         char[] charArr = my_string.toCharArray();
//         char[] result = new char[index_list.length];
        
//         for (int i = 0; i < index_list.length; i++) {
//             result[i] = charArr[index_list[i]];
//         }
        
//         return new String(result);
        
        StringBuilder sb = new StringBuilder();
        
        for (int idx : index_list) {
            sb.append(my_string.charAt(idx));
        }
        
        return sb.toString();
    }
}