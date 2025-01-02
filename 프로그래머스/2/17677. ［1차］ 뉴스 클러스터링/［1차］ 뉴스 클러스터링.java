import java.util.*;
class Solution {
    public List<String> stringSplit(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i + 2 <= str.length(); i++) {
            String s = str.substring(i, i + 2).toUpperCase();
            if(s.matches("[A-Z]+"))
                list.add(s);
        }
        return list;
    }

    public int solution(String str1, String str2) {
        int answer = 65536;
        List <String> s1 = stringSplit(str1);
        List <String> s2 = stringSplit(str2);

        int sum = s1.size() + s2.size();
        int same = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int index = s2.indexOf(s1.get(0));
            if(index != -1) {
                same++;
                s2.remove(index);
            }
            s1.remove(0);
        }

        if(sum != 0)
           answer *= (double)same / (sum - same);
        return answer;
    }
}