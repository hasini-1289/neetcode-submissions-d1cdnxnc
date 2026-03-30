class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        int[] freq = new int[128];   
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        
        int left = 0;
        int right = 0;
        int count = t.length();  
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        
        while (right < s.length()) {
            if (freq[s.charAt(right)] > 0) {
                count--;
            }
            freq[s.charAt(right)]--;
            right++;
            while (count == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    count++;
                }
                
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" 
               : s.substring(startIndex, startIndex + minLength);
    }
}
