import java.util.*;

class Solution {
    private int n;
    private int[] apeachInfo;
    private int maxScoreGap = 1;
    private int[] optLionInfo = {-1};

    public int[] solution(int n, int[] info) {
        this.n = n; 
        this.apeachInfo = info;
        
        int targetScore = 10;
        int usedArrows = 0;
        int[] lionInfo = new int[11];
        int scoreGap = 0;
        
        for (int i = 0; i < 11; i++) {
            if (apeachInfo[i] != 0) {
                scoreGap -= 10 - i;
            }
        }
        
        dfs(targetScore, usedArrows, scoreGap, lionInfo);
        
        return optLionInfo;
    }
    
    private void dfs(int targetScore, int usedArrows, int scoreGap, int[] lionInfo) {         
        checkOptimalSolution(scoreGap, usedArrows, lionInfo);
        
        for (int i = targetScore; i >= 0; i--) {
            if (usedArrows + apeachInfo[10 - i] + 1 > n) continue;
            
            usedArrows += apeachInfo[10 - i] + 1;
            lionInfo[10 - i] += apeachInfo[10 - i] + 1;
            if (apeachInfo[10 - i] == 0) {
                scoreGap += i; 
            } else {
                scoreGap += i * 2;
            }
            
            dfs(i - 1, usedArrows, scoreGap, lionInfo); 
            
            usedArrows -= apeachInfo[10 - i] + 1;
            lionInfo[10 - i] -= apeachInfo[10 - i] + 1;
            if (apeachInfo[10 - i] == 0) {
                scoreGap -= i;
            } else {
                scoreGap -= i * 2;
            }
        }
    }
    
    private void checkOptimalSolution(int scoreGap, int usedArrows, int[] lionInfo) {
        if (scoreGap < maxScoreGap) return;
        
        int[] temp = lionInfo.clone(); 
        temp[10] += n - usedArrows;

        if (isAbsoultelyOptimal(scoreGap, optLionInfo)) {
            maxScoreGap = scoreGap;
            optLionInfo = temp;
            return;
        }

        for (int i = 10; i >= 0; i--) {
            if (temp[i] > optLionInfo[i]) {
                optLionInfo = temp;
                break;
            } else if (temp[i] < optLionInfo[i]) {
                break;
            }
        }
    }
    
    private boolean isAbsoultelyOptimal(int scoreGap, int[] optLionInfo) {
        if (scoreGap > maxScoreGap) {
            return true;
        }
        
        if (optLionInfo.length == 1) {
            return true;
        }
        
        return false;
    }
}