import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = n; i < num_list.length; i++) {
            resultList.add(num_list[i]);
        }
        
        for (int i = 0; i < n; i++) {
            resultList.add(num_list[i]);
        }
        
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
        
        
// 기본 구현
        //         int[] nArr1 = new int[n];
//         for (int i = 0; i < n; i++) {
//             nArr1[i] = num_list[i];
//         }
        
//         int[] nArr2 = new int[num_list.length - n];
//         for (int i = n; i < num_list.length; i++) {
//             nArr2[i - n] = num_list[i];
//         }
        
//         int[] answer = new int[num_list.length];
//         for (int i = 0; i < nArr2.length; i++) {
//             answer[i] = nArr2[i];
//         }
        
//         for (int i = 0; i < nArr1.length; i++) {
//             answer[nArr2.length + i] = nArr1[i];
//         }
        
//         return answer;
    }
}