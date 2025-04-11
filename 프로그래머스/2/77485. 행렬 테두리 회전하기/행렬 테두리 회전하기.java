class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 초기 행렬 생성
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        
        // query가 하나일 때
        if(queries.length == 1){
            int[] query = queries[0];
            int[] answer = {arr[query[0] - 1][query[1] -1]};
            return answer;
        }
        
        // query가 여러개일 때
        // 회전 전 행렬 출력해보기
        /*
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        */
        int[] answer = new int[queries.length];
        int index = 0;
        for(int[] query : queries){
            // 회전 전 최소값을 answer에 추가하고 index 증가
            answer[index++] = get_min(query, arr);
            arr = rotate(query, arr);
        }
        return answer;
    }
    
    public static int get_min(int[] query, int[][] arr){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int min = 10001;
        for(int r = x1; r <= x2; r++){
            for(int c = y1; c <= y2; c++){
                // 중간에 껴있는 애들 제외
                if(x1 < r && r < x2){
                    if(y1 < c && c < y2){
                        continue;
                    }
                }
                if(arr[r][c] < min){
                    min = arr[r][c];
                }
            }
        }
        return min;
    }
    
    public static int[][] rotate(int[] query, int[][] arr){
        // 새 행렬 생성
        int[][] new_arr = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j++){
                new_arr[i][j] = arr[i][j];
            }
        }
        
        // query 분석. index 값으로 만들기 위해 -1
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        for(int r = x1; r <= x2; r++){
            for(int c = y1; c <= y2; c++){
                // 오른쪽(→) 으로 움직이는 경우
                if(r == x1){
                    if(y1 <= c && c < y2){
                        new_arr[r][c + 1] = arr[r][c];
                        //System.out.println(r + ", " + c + "→");
                    }
                }
                // 아래(↓)로 움직이는 경우
                if(c == y2){
                    if(x1 <= r && r < x2){
                        new_arr[r+1][c] = arr[r][c];
                        //System.out.println(r + ", " + c + "↓");
                    }
                }
                // 왼쪽(←)으로 움직이는 경우
                if(r == x2){
                    if(y1 < c && c <= y2){
                        new_arr[r][c-1] = arr[r][c];
                        //System.out.println(r + ", " + c + "←");
                    }
                }
                // 위(↑)로 움직이는 경우
                if(c == y1){
                    if(x1 < r && r <= x2){
                        new_arr[r-1][c] = arr[r][c];
                        //System.out.println(r + ", " + c + "↑");
                    }
                }
            }
        }
        
        return new_arr;
    }
}