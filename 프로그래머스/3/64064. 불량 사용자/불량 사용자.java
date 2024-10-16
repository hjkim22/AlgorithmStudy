import java.util.*;
class Solution {
    Set<Integer> resultSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int banLen = banned_id.length, userLen = user_id.length;
        boolean[][] map = new boolean[banLen][userLen];
        for(int i = 0 ; i < banLen ; i++){
            for(int j = 0 ; j < userLen ; j++){
                if(match(banned_id[i], user_id[j])) map[i][j] = true;
            }
        }
        dfs(banLen, userLen, map, new boolean[userLen], 0);
        return resultSet.size();
    }
    public void dfs(int banLen, int userLen, boolean[][] map, boolean[] visited, int index){
        if(index >= banLen){
            int result = 0;
            for(int i = 0 ; i < userLen ; i++)
                if(visited[i]) result += 2 << i;
            resultSet.add(result);
            return;
        }
        int count = 0;
        for(int j = 0 ; j < userLen ; j++){
            if(map[index][j] && !visited[j]){
                visited[j] = true;
                dfs(banLen, userLen, map, visited, index+1);
                visited[j] = false;
            }
        }
    }
    public boolean match(String a, String b){
        if (a.length() != b.length()) return false;
        int len = a.length();
        for(int i = 0 ; i < len ; i++){
            if(a.charAt(i) != '*' && a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}