class Solution {

    // function to compare two frequency arrays
    public boolean isSame(int freq1[], int freq2[]) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        int k = s1.length();

        // count characters of s1
        for (int i = 0; i < k; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (isSame(freq1, freq2)) return true;

        // sliding window
        for (int i = k; i < s2.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;        
            freq2[s2.charAt(i - k) - 'a']--;    

            if (isSame(freq1, freq2)) return true;
        }

        return false;
    }
}
