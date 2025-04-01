import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] array = new int[n][n];
        for(int[] row: array){
            Arrays.fill(row, 0);
        }

        int length = (((n * n) - n) / 2) + n;
        char action = 'v'; //v, h, d, 아래, 오른쪽, 왼쪽위 대각
        int x = 0;
        int y = -1;
        for(int i = 1; i <= length; i++){
            if(action == 'v'){
                y++;
                if((y + 1 >= n || array[y+1][x] != 0)){
                    action = 'h';
                }
            }
            else if(action == 'h'){
                x++;
                if((x + 1 >= n || array[y][x+1] != 0)){
                    action = 'd';
                }
            }
            else{
                x--;
                y--;
                if((x - 1 <= 0 || array[y-1][x-1] != 0)){
                    action = 'v';
                }
            }
            array[y][x] = i;
        }

        int[] answer = new int[length];

        int index = 0;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[index] = array[i][j];
                index++;
            }
        }


        return answer;
    }
}
