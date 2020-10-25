import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int cost = 0;
        boolean[] dayIncluded = new boolean[366];

        for (int i = days.length - 1; i >= 0; i++) {
            if(days[days.length - 1]-days[i]>=1) {
                cost = Math.min(cost+costs[0], costs[0]);
            }
            else if(days[i+1]-days[i]>=7){

            }
        }
    }
}
