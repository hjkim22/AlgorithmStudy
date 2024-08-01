import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] names) {
//         List<String> list = new ArrayList<>();
        
//         for (int i = 0; i < names.length; i += 5) {
//             list.add(names[i]);
//         }
//         return list.toArray(new String[0]);
        int size = (names.length + 4) / 5;
        String[] result = new String[size];
        
        int first = 0;
        for (int i = 0; i < names.length; i += 5) {
            result[first++] = names[i];
        }
        return result;
    }
}