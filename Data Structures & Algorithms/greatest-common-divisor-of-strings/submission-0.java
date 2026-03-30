class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // If concatenation property fails, no GCD string exists
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find gcd of lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // The prefix of gcd length is the answer
        return str1.substring(0, gcdLength);
    }

    // Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
