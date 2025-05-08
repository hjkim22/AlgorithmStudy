import java.util.HashSet;
import java.util.Set;

class Solution {
	public static String[] solution(int[][] line) {
		int minC = Integer.MAX_VALUE;
		int minR = Integer.MAX_VALUE;
		int maxC = Integer.MIN_VALUE;
		int maxR = Integer.MIN_VALUE;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				int temp = line[i][0] * line[j][1] - line[i][1] * line[j][0];
				int temp1 = line[i][1] * line[j][2] - line[i][2] * line[j][1];
				int temp2 = line[i][2] * line[j][0] - line[i][0] * line[j][2];
				if (temp == 0 || temp1 % temp != 0 || temp2 % temp != 0)
					continue;

				int x = temp1 / temp;
				int y = temp2 / temp;

				set.add(x + "," + y);
				minR = Math.min(minR, x);
				minC = Math.min(minC, y);
				maxR = Math.max(maxR, x);
				maxC = Math.max(maxC, y);
			}
		}
		// 교점이 없는 경우
		if (minR == Integer.MAX_VALUE) {
			String[] answer = new String[1];
			answer[0] = "*";
			return answer;
		}

		// 위 맨 왼쪽 ~ 아래 맨 오른쪽까지
		String[] answer = new String[maxC - minC + 1];
		int index = 0;
		for (int i = maxC; i >= minC; i--) {
			StringBuilder sb = new StringBuilder();
			for (int j = minR; j <= maxR; j++) {
				if (set.contains(j + "," + i)) {
					sb.append("*");
				} else
					sb.append(".");
			}
			answer[index++] = sb.toString();
		}
        return answer;
	}
}