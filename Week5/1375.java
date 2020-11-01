class Solution {
    public int numTimesAllBlue(int[] light) {
        int maxLightOn = 0;
        int res = 0;
        
        for (int i = 0; i < light.length; i++) {
            maxLightOn = Math.max(maxLightOn, light[i]);
            if (maxLightOn == i + 1) res++;
        }
        
        return res;
    }
}