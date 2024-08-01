class Solution {
    public int solution(int hp) {
        int generalAtk = 5;
        int soldierAtk = 3;
        int workerAtk = 1;
        
        int generalCnt = hp / generalAtk;
        hp %= generalAtk;
        int soldierCnt = hp / soldierAtk;
        hp %= soldierAtk;
        int workerCnt = hp / workerAtk;
        
        return generalCnt + soldierCnt + workerCnt;
    }
}