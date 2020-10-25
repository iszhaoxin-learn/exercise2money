class Solution {
    public String reformat(String s) {
        String result = "";
        String num = "";
        String alpha = "";
        for(char c : s.toCharArray()){
            if(c>='a'){
                alpha += c;
            }
            else{
                num+=c;
            }
        }
        if(Math.abs(alpha.length()-num.length())>1){
            return result;
        }
        else if(alpha.length()>num.length()){
            result += alpha.charAt(0);
            for(int i=0; i<num.length(); i++){
                result += num.charAt(i);
                result += alpha.charAt(i+1);
            }
        }
        else if(alpha.length()==num.length()){
            for(int i=0; i<num.length(); i++){
                result += alpha.charAt(i);
                result += num.charAt(i);
            }
        }
        else{
            result += num.charAt(0);
            for(int i=0; i<alpha.length(); i++){
                result += alpha.charAt(i);
                result += num.charAt(i+1);
            }
        }
        return result;
    }
}