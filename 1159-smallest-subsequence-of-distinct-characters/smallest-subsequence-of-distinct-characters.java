class Solution {
    public String smallestSubsequence(String s) {
        int[] frequency = new int[26];
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            frequency[current - 'a']--;
            if (used[current - 'a']) {
                continue;
            }
            while (result.length() > 0 &&
                   result.charAt(result.length() - 1) > current &&
                   frequency[result.charAt(result.length() - 1) - 'a'] > 0) {
                char removed = result.charAt(result.length() - 1);
                used[removed - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            result.append(current);
            used[current - 'a'] = true;
        }
        return result.toString();
    }
}