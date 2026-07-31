import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (int i = 0, n = word.length(); i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int result = 0;
        int rank = 0;
        for (int i = 25; i >= 0 && freq[i] != 0; i--, rank++) {
            result += freq[i] * (rank / 8 + 1);
        }
        return result;
    }
}