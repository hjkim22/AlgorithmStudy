class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(board[r][c] == 1) continue;
                boolean flag = true;
                for(int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }
}