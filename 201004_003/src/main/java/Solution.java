import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int m = 1;
        int max = 0;
        for (int i = 0; i < s.length(); i+=m) {
            HashMap<Character, Integer> indd = new HashMap<Character, Integer>();
            for (int j = i; j < s.length(); j++) {
                if(!indd.containsKey(s.charAt(j))){
                    indd.put(s.charAt(j), indd.size());
                }
                else{
                    m = indd.get(s.charAt(j)) + 1;
                    break;
                }
                m = 1;
            }
            if(max<indd.size())
                max = indd.size();
            if(i+indd.size()==s.length())
                break;
        }
        System.out.println(max);
        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        String substr = new String();
        int ind;
        for (int i = 0; i < s.length(); i++) {
            ind = substr.indexOf(s.charAt(i));
            if (ind != -1)
                if(substr.length()>max)
                    max = substr.length();
            substr = substr.substring(ind+1);
            substr += s.charAt(i);
        }
        if(substr.length()>max)
            max = substr.length();
        return max;
    }
}