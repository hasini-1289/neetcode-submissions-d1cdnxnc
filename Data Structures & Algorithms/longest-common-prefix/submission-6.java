class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) return "";
        String first = strs[0];
        String prefix ="";
        for(int i=0;i<first.length();i++){
            char ch = first.charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!= ch) {
                    return prefix;
                }
            }
            prefix += ch;
        }
        return prefix;
    }
}