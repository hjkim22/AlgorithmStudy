class Solution {
    public String solution(String number, int k) {
StringBuilder answer = new StringBuilder();
		int cnt = 0;
		char max = '0';
		if (number.charAt(0) == '0') {
			answer.append("0");
		}
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';
			for (int j = cnt; j <= k + i; j++) {	
				if (number.charAt(j) > max) {
					max = number.charAt(j);	
					cnt = j + 1;

				}
			}
			answer.append(max);
		}
        return answer.toString();
    }
}