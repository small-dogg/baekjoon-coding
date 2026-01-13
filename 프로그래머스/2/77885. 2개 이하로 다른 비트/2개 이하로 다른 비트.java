import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();
        for (long number : numbers) {
            list.add(func(number));
        }

        return list.stream().mapToLong(Long::longValue).toArray();
    }

    private Long func(long number) {
        if (number % 2 == 0) {
            return number + 1;
        } else {
            String number2 = Long.toBinaryString(number);
            if (number2.contains("0")) {
                int i = number2.lastIndexOf("0");
                number2 = number2.substring(0, i) + "10" + number2.substring(i + 2);
            } else {
                number2 = "10" + number2.substring(1);
            }
            return Long.parseLong(number2, 2);
        }
    }
}