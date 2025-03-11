import java.util.*;
class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.compareTo(head2) == 0) {
                int num1 = getNumber(o1);
                int num2 = getNumber(o2);
                return num1 - num2;
            }
            else {
                return head1.compareTo(head2);
            }
        });

        return files;
    }
    public static int getNumber(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        while (idx < arr.length && !Character.isDigit(arr[idx])) {
            idx++;
        }
        
        while (idx < arr.length && Character.isDigit(arr[idx])) {
            sb.append(arr[idx]);
            idx++;
        }
        return Integer.parseInt(sb.toString());
    }
}