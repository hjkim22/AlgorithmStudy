import java.util.*;

class Solution {
    static ArrayList<String> uniKey = new ArrayList<>();
    static ArrayList<String> cdKey = new ArrayList<>();
    static int n, m;
    static boolean[] visit;
    static String[][] rel;

    public int solution(String[][] relation) { 
        n = relation.length;
        m = relation[0].length;

        visit = new boolean[m];
        rel = relation;

        DFS(0, new StringBuilder());

        uniKey.sort((o1, o2) -> o1.length() == o2.length() ? 
                o1.compareTo(o2) : o1.length() - o2.length());

        for(int i=0;i<uniKey.size();i++)
            if(isMin(i))
                cdKey.add(uniKey.get(i));

        return cdKey.size();
    }

    static void DFS(int start, StringBuilder sb) {
        for(int i=start;i<m;i++) {
            if(!visit[i]) {
                visit[i] = true;
                sb.append(i);

                String tuple = sb.toString();
                if(isUnique(tuple))
                    uniKey.add(tuple);

                if(i + 1 != m)
                    DFS(i + 1, sb);
                visit[i] = false;
                sb.setLength(sb.length() - 1);
            }
        }
    }

    static boolean isMin(int idx) {
        String target = uniKey.get(idx);
        HashSet<Integer> set = new HashSet<>();

        for(char c : target.toCharArray())
            set.add(c - '0');

        for(String s : cdKey) {
            int check = 0;
            for(char c : s.toCharArray()) {
                int i = c - '0';
                if(!set.contains(i))
                    break;
                check++;
            }
            if(check == s.length())
                return false;
        }

        return true;
    }

    static boolean isUnique(String s) {
        // 문자열, 출현 개수
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                sb.append(rel[i][c - '0']);
            }
            String tuple = sb.toString();
            map.put(tuple, map.getOrDefault(tuple, 0) + 1);
        }

        for(int i : map.values())
            if(i > 1) return false;

        return true;
    }
}