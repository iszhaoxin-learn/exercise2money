class Solution {
    public int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1))
                return i;
        }
        
        return 0;
    }
}