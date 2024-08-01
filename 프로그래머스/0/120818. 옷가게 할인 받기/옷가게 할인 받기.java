class Solution {
    public int solution(int price) {
        // int discount = 0;
        // if (price > 500_000) {
        //     discount = 20;
        // } else if (price > 300_000) {
        //     discount = 10;
        // } else if (price > 100_000) {
        //     discount = 5;
        // } else {
        //     return -1;
        // }
        // return price - (price * discount) / 100;
        if (price >= 500_000) {
            price *= 0.8;
        } else if (price >= 300_000) {
            price *= 0.9;
        } else if (price >= 100_000) {
            price *= 0.95;
        }
        return (int) price;
    }
}