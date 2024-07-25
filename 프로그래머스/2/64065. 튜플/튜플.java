import java.util.*;

public class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("\\},\\{");
        
        List<Set<Integer>> list = new ArrayList<>();
        for (String set : sets) {
            String[] elements = set.split(",");
            Set<Integer> tempSet = new HashSet<>();
            for (String element : elements) {
                tempSet.add(Integer.parseInt(element));
            }
            list.add(tempSet);
        }

        Collections.sort(list, Comparator.comparingInt(Set::size));

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Set<Integer> set : list) {
            for (int num : set) {
                if (seen.add(num)) {
                    result.add(num);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}