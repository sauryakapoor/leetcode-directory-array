import java.math.BigInteger;
class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        int halfLength = s.length() / 2;
        int[] halfCount = new int[26];
        char middleCharacter = 0;
        for (int i = 0; i < 26; i++) {
            halfCount[i] = frequency[i] / 2;

            if (frequency[i] % 2 == 1) {
                middleCharacter = (char) ('a' + i);
            }
        }
        BigInteger totalWays = factorial(halfLength);
        for (int count : halfCount) {
            if (count > 1) {
                totalWays = totalWays.divide(factorial(count));
            }
        }
        BigInteger requiredPosition = BigInteger.valueOf(k);
        if (totalWays.compareTo(requiredPosition) < 0) {
            return "";
        }
        StringBuilder firstHalf = new StringBuilder();
        int remaining = halfLength;
        while (remaining > 0) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) {
                    continue;
                }
                BigInteger currentBlock =
                        totalWays
                                .multiply(BigInteger.valueOf(halfCount[i]))
                                .divide(BigInteger.valueOf(remaining));
                if (requiredPosition.compareTo(currentBlock) > 0) {
                    requiredPosition = requiredPosition.subtract(currentBlock);
                } else {
                    firstHalf.append((char) ('a' + i));
                    totalWays = currentBlock;
                    halfCount[i]--;
                    remaining--;
                    break;
                }
            }
        }
        String secondHalf = firstHalf.reverse().toString();
        firstHalf.reverse();
        if (middleCharacter != 0) {
            return firstHalf.toString()
                    + middleCharacter
                    + secondHalf;
        }
        return firstHalf.toString() + secondHalf;
    }
    private BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}