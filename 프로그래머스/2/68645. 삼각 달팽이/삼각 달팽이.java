import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        int[][] array = new int[n][n];
        int num = 2;
        int x = 0;
        int y = 0;
        int direction = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(array[i], 0);
        }
        int max = (n * (n + 1)) / 2;
        array[0][0] = 1;
        while (num <= max) {
            switch (direction % 3) {
                case 0: {
                    for (int i = y; i < n; i++) {
                        y++;
                        if (y >= n || array[y][x] != 0) {
                            y--;
                            break;
                        } else {
                            array[y][x] = num;
                            num++;
                        }
                    }
                    break;
                }
                case 1: {
                    for (int i = x; i < n; i++) {
                        x++;
                        if (x >= n || array[y][x] != 0) {
                            x--;
                            break;
                        } else {
                            array[y][x] = num;
                            num++;
                        }
                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < n; i--) {
                        x--;
                        y--;
                        if (x < 0 || y < 0 || array[y][x] != 0) {
                            x++;
                            y++;
                            break;
                        } else {
                            array[y][x] = num;
                            num++;
                        }
                    }
                    break;
                }
            }
            direction++;
        }
        int k = 0;
        answer = new int[max];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[k] = array[i][j];
                k++;
            }
        }
        return answer;
    }
}