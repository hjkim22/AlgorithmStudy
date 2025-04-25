import java.util.*;

class Solution {

    StringBuilder sb = new StringBuilder();

    public void combination(HashMap<String, Integer> combinations, String order, int n, int k){
        if (sb.length() == n) {
            combinations.put(sb.toString(), combinations.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = k; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(combinations, order, n, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        Arrays.sort(course);

        HashSet<String> result = new HashSet<>();

        for(int i = 0; i < orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }

        for (int courseNum: course) {

            HashMap<String, Integer> combinations = new HashMap<>();
            for (String order: orders)
                combination(combinations, order, courseNum, 0);

            int maxOrderCnt = -1;
            for (Map.Entry<String, Integer> entry: combinations.entrySet())
                maxOrderCnt = Math.max(maxOrderCnt, entry.getValue());

            if(maxOrderCnt < 2)
                continue;

            for (Map.Entry<String, Integer> entry: combinations.entrySet())
                if (entry.getValue() == maxOrderCnt)
                    result.add(entry.getKey());
        }

        String[] resultArray = result.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}