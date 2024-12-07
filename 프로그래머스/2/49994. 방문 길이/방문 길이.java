class Solution {
    static int answer = 0;
    public int solution(String dirs) {
        int[][] move = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        boolean[][][][] visit = new boolean[11][11][11][11];
        int[] position = {5, 5};
        for(char c : dirs.toCharArray()) {
            switch(c) {
            case 'U' -> moving(position, move[0], visit);
            case 'D' -> moving(position, move[1], visit);
            case 'R' -> moving(position, move[2], visit);
            case 'L' -> moving(position, move[3], visit);
            }
        }
        return answer;
    }

    private static void moving(int[]p, int[] m, boolean[][][][] v) {
        if((p[0] + m[0]) <= 10 && (p[0] + m[0]) >= 0 && (p[1] + m[1]) <= 10 && (p[1] + m[1]) >= 0) {
            int[] before = p.clone();
            p[0] += m[0];
            p[1] += m[1];
            if(!v[p[0]][p[1]][before[0]][before[1]]) {
                v[p[0]][p[1]][before[0]][before[1]] = true;
                v[before[0]][before[1]][p[0]][p[1]] = true;
                answer++;
            }
        }
    }
}