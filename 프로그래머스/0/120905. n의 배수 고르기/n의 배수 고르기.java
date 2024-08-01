import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int num : numlist) {
            if (num % n == 0) {
                resultList.add(num);
            }
        }
        
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        
        return resultArr;
    }
}