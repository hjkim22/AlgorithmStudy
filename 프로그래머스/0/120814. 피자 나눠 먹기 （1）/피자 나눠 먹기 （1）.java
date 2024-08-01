class Solution {
    public int solution(int n) {
        // if (n % 7 == 0) {
        //     return n / 7;
        // } else {
        //  return n / 7 + 1;    
        // }
        
        int pizzas = n / 7;
        if (n % 7 != 0) {
            pizzas += 1;
        }
        return pizzas;
    }
}