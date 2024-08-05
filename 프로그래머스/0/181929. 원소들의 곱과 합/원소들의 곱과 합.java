class Solution {
    public int solution(int[] num_list) {
//         기본 구현
//         int plusNum = 0;
//         int multiNum = 1;
        
//         for (int i = 0; i < num_list.length; i++) {
//             plusNum += num_list[i];
//             multiNum *= num_list[i];
//         }
        
//         if (plusNum * plusNum > multiNum) {
//             return 1;
//         } else {
//             return 0;
//         }
        
        int multi = 1;
        for (int num : num_list) {
            multi *= num;
        }
        
        int sum = 0;
        for (int num : num_list) {
            sum += num;
        }
        int sqrt = sum * sum;
        
        return multi < sqrt ? 1 : 0;
        
    }
}