
class Solution {
    public String longestPalindrome(String s) {
//        System.out.println();
//        System.out.println(s);
        int maxlen = 0;
        int mode = -2;
        int len = 0;
        String palindrome = new String();
        int center = -1;
        for (int i = 0; i < s.length()-2; i++) {
            if (mode!=-1){
                if (Character.compare(s.charAt(i), s.charAt(center-len-mode)) == 0){
                    len += 1;
                    assert i-center==len;
                    palindrome = s.substring(center-len-mode, i+2);
                    System.out.println(palindrome);
                }
                else{
                    mode = -1;
                    len = 0;
                }
            }
            if (s.charAt(i) == s.charAt(i+1)){
                center = i;
                mode = 0;
                palindrome = s.substring(i, i+2);
                System.out.format("Center : %s - Mode : %d - Substring : %s\n", palindrome, mode, s.substring(0, i+2));
            }
            else if (s.charAt(i) == s.charAt(i+2)){
                center = i+1;
                mode = 1;
                palindrome = s.substring(i, i+3);
                System.out.format("Center : %s - Mode : %d - Substring : %s\n", palindrome, mode, s.substring(0, i+3));
            }
            else{
                mode = -1;
            }

//            System.out.println(s.charAt(i));
        }


        return "as";
    }
}