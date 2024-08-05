class Solution {
    public int solution(int n, String control) {
//         기본 구현
//         int answer = 0;
//         char[] charArr = control.toCharArray();
        
//         for (int i = 0; i < control.length(); i++) {
//             if (charArr[i] == 'w') {
//                 answer +=1;
//             } else if (charArr[i] == 's') {
//                 answer -= 1;
//             } else if (charArr[i] == 'd') {
//                 answer += 10;
//             } else if (charArr[i] == 'a') {
//                 answer -= 10;
//             }
//         }
//         return answer;
        
        for (char ch : control.toCharArray()) {
            switch (ch) {
                case 'w':
                    n += 1;
                    break;
                case 's':
                    n -= 1;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}