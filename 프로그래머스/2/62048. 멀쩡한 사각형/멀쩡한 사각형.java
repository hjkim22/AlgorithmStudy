class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double H = (double) h;
        double W = (double) w;

        for(int x = 1; x < w; x++){
            double r = H*x/W % 1;
            if(r == 0){
                answer += H*x/W;
            } else {
                answer += H*x/W - r;
            }
        }
        return answer*2;
    }   
}