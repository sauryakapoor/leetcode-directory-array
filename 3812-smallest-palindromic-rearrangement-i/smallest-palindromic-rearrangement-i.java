class Solution {
    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        StringBuilder leftHalf = new StringBuilder();
        char middleCharacter = '\0';
        for (int i = 0; i < 26; i++) {
            int halfCount = frequency[i] / 2;
            for (int j = 0; j < halfCount; j++) {
                leftHalf.append((char) ('a' + i));
            }
            if (frequency[i] % 2 == 1) {
                middleCharacter = (char) ('a' + i);
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(leftHalf);
        if (middleCharacter != '\0') {
            answer.append(middleCharacter);
        }
        answer.append(new StringBuilder(leftHalf).reverse());
        return answer.toString();
    }
}