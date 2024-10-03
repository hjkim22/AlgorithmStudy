import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        
        int maxWork = works[works.length-1];
        int len = maxWork+1;
        int[] leftWork = new int[len];
        
        for(int tmp : works) leftWork[tmp]++;
        
        while(maxWork > 0 && n > 0){
            if(leftWork[maxWork] == 0) maxWork--;
            else if(leftWork[maxWork] <= n){
                leftWork[maxWork-1] += leftWork[maxWork];
                n -= leftWork[maxWork];
                leftWork[maxWork] = 0;
                maxWork--;
            } else {
                leftWork[maxWork-1] += n;
                leftWork[maxWork] -= n;
                n = 0;
            }
        }
        
        for(int i = 1 ; i < len ; i++)
            answer += Math.pow(i, 2)*leftWork[i];
        
        return answer;
    }
}