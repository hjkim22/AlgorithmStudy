import java.util.*;
class Solution {
    public int solution(int n) {
		int answer = 0;
		String num = Integer.toBinaryString(n);
		int nc = 0;
		char[] charn = num.toCharArray();
		for (int i = 0; i < charn.length; i++) {
			if (charn[i] == '1') {
				nc++;
			}
		}
		for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
			char[] temp = Integer.toBinaryString(i).toCharArray();
			int tempnum = 0;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] == '1') {
					tempnum++;
				}
			}
			if (nc == tempnum) {
				answer = i;
				break;
			}

		}
		return answer;
    }
}