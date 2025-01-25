import java.util.*;

class Solution {
    int dis[] = {10,20,30,40};
    int userLen, emoLen;
    ArrayList<int[]> ans ;
    public int[] solution(int[][] users, int[] emoticons) {
        ans = new ArrayList<>();
        int[] answer ;
        userLen= users.length;
        emoLen = emoticons.length;
        ans.add(new int[]{0,0});
        

	//모든 경우의 수를 리스트에 담는다. 
        dfs(users,emoticons, new int[emoLen], 0 );
    //리스트 소팅
        Collections.sort(ans, (a,b)-> b[0]-a[0] == 0 ? b[1]-a[1] : b[0]-a[0]);
	//답을 리턴한다.
        return ans.get(0);
    }
    public void dfs(int[][] u, int[] e,int[] disInfo, int level){
        if(level == emoLen){//종료 조건
            int buyCnt = 0 ;
            int buySum = 0;
            
            for(int i = 0 ;i < userLen ;i++){
                int sum = 0 ;
                for(int j =0 ; j< emoLen; j++){
                    if(disInfo[j] >= u[i][0]) 
                        sum+= e[j]/100*(100-disInfo[j]);
                }
                if(sum >= u[i][1]){
                    buyCnt++;
                }else{
                    buySum += sum;
                }    
            }
            ans.add(new int[]{buyCnt,buySum});
            return;
        }else{
            for(int i = 0 ;i < 4 ;i++){
                disInfo[level] = dis[i];
                dfs(u,e,disInfo, level+1);
            }
        }
    }
}