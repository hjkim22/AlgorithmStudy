import java.util.*;

class Solution {
    public int[] solution (String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String,String> root = new HashMap<>();
        Map<String,Integer> total= new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            if(referral[i].equals("-")){
              root.put(enroll[i],"center");   
            }          
            else{
             root.put(enroll[i],referral[i]);                  
            }
            total.put(enroll[i],0);
        }
        
        for(int i=0;i<seller.length;i++){
           String kid=seller[i];
           String parent=root.get(seller[i]);
           int money=amount[i]*100;
           while(true){
               total.put(kid,total.get(kid)+money-money/10);
               money/=10;
               if(money==0||parent.equals("center")){
                   break;
               }
               
               kid=parent;
               parent=root.get(kid);                            
           }
        }
        
       for(int i=0;i<enroll.length;i++){
           answer[i]=total.get(enroll[i]);
       }
        
        return answer;
    }
}