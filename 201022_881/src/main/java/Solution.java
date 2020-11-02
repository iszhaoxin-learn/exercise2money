import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        System.out.println(people);
        int i = 0;
        int j = people.length-1;
        int num = 0;
        while(i<=j){
            if(people[j]+people[i]>limit){
                j-=1;
            }
            else{
                i+=1;
                j-=1;
            }
            num +=1;
        }
        return num;
    }
}


/**
 * 这个题其实不算难，但是这有一个思想是双数组。
 * 从数字的两边向中间靠拢
 * 这个题的关键还是要能确认这个逻辑
 */