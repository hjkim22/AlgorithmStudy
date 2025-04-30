class Solution {
    public int solution(int [][]board) {
		int max = 0, size = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 1) {
					size = 1;
					if(i != 0 && j != 0) {
						board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
						size = board[i][j];
					}
					max = max < size ? size : max;
				}
			}
		}
		
		return max * max;
    }
}