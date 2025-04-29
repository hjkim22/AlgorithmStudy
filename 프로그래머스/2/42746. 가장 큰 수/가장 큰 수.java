import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        int n = numbers.length;
        String[] arr = new String[n];

        for(int i=0; i<n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
         
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}