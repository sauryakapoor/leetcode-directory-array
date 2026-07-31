import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for (int i = 0; i < word.length(); i++) {
            frequency[word.charAt(i) - 'a']++;
        }
        Arrays.sort(frequency);
        int answer = 0;
        int position = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) {
                break;
            }
            int pushes = (position / 8) + 1;
            answer += frequency[i] * pushes;
            position++;
        }
        return answer;
    }
}