class Solution {
    public int solution(int a, int b) {
//         StringBuilder 사용
//         StringBuilder sb = new StringBuilder();
        
//         sb.append(a);
//         sb.append(b);
//         int aTob = Integer.parseInt(sb.toString());
        
//         int multi = 2 * a * b;
        
//         if (aTob >= multi) {
//             return aTob;
//         } else {
//             return multi;
//         }
        
        String aTob = Integer.toString(a) + Integer.toString(b);
        int concat = Integer.parseInt(aTob);
        int multi = 2 * a * b;
        
        if (concat < multi) {
            return multi;
        } else {
            return concat;
        }
    }
}