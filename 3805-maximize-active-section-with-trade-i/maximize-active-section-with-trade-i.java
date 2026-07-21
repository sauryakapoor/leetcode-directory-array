class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        int maxGain = 0;
        int previousZeros = 0;
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1') {
                ones++;
            }
        }
        while (i < n) {
            int currentZeros = 0;
            while (i < n && s.charAt(i) == '0') {
                currentZeros++;
                i++;
            }
            if (previousZeros > 0 && currentZeros > 0) {
                maxGain = Math.max(
                    maxGain,
                    previousZeros + currentZeros
                );
            }
            if (currentZeros > 0) {
                previousZeros = currentZeros;
            }
            while (i < n && s.charAt(i) == '1') {
                i++;
            }
        }
        return ones + maxGain;
    }
}