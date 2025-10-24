//풀이수준 : B+
class Solution {
    
        private final String[] COUNT = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    
    public int solution(String s) {
        String val = s;
        for (int i = 0; i < COUNT.length; i++) {
            val = val.replaceAll(COUNT[i], i + "");
        }
        return Integer.parseInt(val);
    }
}