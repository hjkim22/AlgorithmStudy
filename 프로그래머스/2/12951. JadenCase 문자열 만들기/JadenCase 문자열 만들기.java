class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        char endCharacter = s.charAt(s.length()-1); // 마지막 글자
        
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                
                char alpha = words[i].charAt(j);
                
                if(j == 0) alpha = Character.toUpperCase(alpha); // 첫 글자는 무조건 대문자
                else alpha = Character.toLowerCase(alpha); // 그 다음 글자부터는 소문자
                
                answer += alpha;
            }
            
            answer += ' '; // 단어가 끝날 때마다 공백 추가
        }
        
        if(endCharacter == ' '){
            return answer;
        } else{
            return answer.trim();
        }
    }
}