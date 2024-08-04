class Solution {
    public int solution(int n, int k) {
        int kkochi = 12000;
        int drink = 2000;
        int serviceDrink = n / 10;
        int amount = (kkochi * n) + (drink * k) - (drink * serviceDrink);
        
        return amount;
    }
}