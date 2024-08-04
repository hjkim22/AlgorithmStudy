import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] num_list) {
        // 기본구현 1
        // int[] answer = new int[num_list.length];
        // int idx = 0;
        // for (int i = num_list.length - 1; i >= 0; i--) {
        //     answer[idx] = num_list[i];
        //     idx++;
        // }
        // return answer;
        
        // Collections.reverse
//         List<Integer> list = new ArrayList<>();
        
//         for (int num : num_list) {
//             list.add(num);
//         }
        
//         Collections.reverse(list);
        
//         int[] result = new int[list.size()];
//         for (int i = 0; i < list.size(); i++) {
//             result[i] = list.get(i);
//         }
//         return result;
        
        // 배열 양쪽 교환 방법
        int left = 0;
        int right = num_list.length - 1;
        
        while (left < right) {
            int temp = num_list[left];
            num_list[left] = num_list[right];
            num_list[right] = temp;
            
            left++;
            right--;
        }
        return num_list;
    }
}