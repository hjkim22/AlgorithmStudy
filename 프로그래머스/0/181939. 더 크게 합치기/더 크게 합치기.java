class Solution {
    public int solution(int a, int b) {
        String aTob1 = a + "" + b;
        int concat1 = Integer.parseInt(aTob1);
        String aTob2 = b + "" + a;
        int concat2 = Integer.parseInt(aTob2);
        
        return concat1 >= concat2 ? concat1 : concat2;
    }
}