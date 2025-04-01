import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		String str = new String();
		for(int i=0; i<str1.length()-1; i++) {
			str = str1.substring(i, i+2);
			if(str.matches("^[a-z]*$")) {
				list1.add(str);
			}
		}
		for(int i=0; i<str2.length()-1; i++) {
			str = str2.substring(i, i+2);
			if(str.matches("^[a-z]*$")) {
				list2.add(str);
			}
		}
        
        if(list1.size() == 0 && list2.size() == 0) {
			answer = 65536;
		} else {
			int cnt = 0;
			for(int i=0; i<list1.size(); i++) {
				str = list1.get(i);
				if(list2.contains(str)) {
					list1.remove(str);
					list2.remove(str);
					cnt++;
					i--;
				}
			}
			
	        answer = (int) ((double) cnt / (cnt + list1.size() + list2.size()) * 65536);
		}
        return answer;
    }
}