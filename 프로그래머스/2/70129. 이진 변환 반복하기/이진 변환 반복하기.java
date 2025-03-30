public class Solution {
    public static int[] solution(String s) {
        int zeroCnt = 0, loopCnt = 0;
        
        while(!s.equals("1")) {
        	for(int i=0; i<s.length(); i++) {
        		char ch = s.charAt(i);
        		if(ch=='0') zeroCnt++;
        	}
        	int len = s.replaceAll("0", "").length();
        	s = Integer.toString(len,2);
        	loopCnt++;
        }
        int[] answer = new int[2];
        answer[0] = loopCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}