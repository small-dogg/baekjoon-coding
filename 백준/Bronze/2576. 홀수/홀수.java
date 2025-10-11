import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> intList = new ArrayList<>();

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            intList.add(Integer.parseInt(s));
        }

        List<Integer> list = intList.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());


        int sum = list.stream()
                .mapToInt(x -> x).sum();
        System.out.println(sum == 0 ? -1 : sum);

        if (sum != 0) {
            System.out.println(list.stream()
                    .min(Integer::compareTo)
                    .orElse(-1));
        }

    }
}
