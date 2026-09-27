class Solution {
    public int lengthOfLastWord(String s) {
        Stack<String> st = new Stack<>();
        for(String word : s.trim().split(" +")){
            st.push(word);
        }
        return st.peek().length();
    }
}