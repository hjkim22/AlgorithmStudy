class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        } else {
            int sumArr1 = 0;
            int sumArr2 = 0;
            
            for (int i = 0; i < arr1.length; i++) {
                sumArr1 += arr1[i];
            }
            for (int i = 0; i < arr2.length; i++) {
                sumArr2 += arr2[i];
            }
            
            if (sumArr1 > sumArr2) {
                return 1;
            } else if (sumArr1 < sumArr2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
