class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = 1;
        int max_flower = 0;
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i]==0){
                size += 1;
            }
            else{
                max_flower += maxinum_flower(size);
                size = 0;
            }
        }
        max_flower += maxinum_flower(size+1);
        return max_flower>=n;
    }
    private int maxinum_flower(int zero_plot){
        return (zero_plot-1)/2;
    }
}