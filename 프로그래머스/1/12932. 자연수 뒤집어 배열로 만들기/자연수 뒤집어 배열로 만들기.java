class Solution {
    public int[] solution(long n) {
        String reverse = new StringBuilder(String.valueOf(n)).reverse().toString();
        char[] charArray = reverse.toCharArray();
        int[] result = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            result[i] = Character.getNumericValue(charArray[i]);
        }
        
        return result;
    }
}