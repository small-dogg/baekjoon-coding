import java.util.ArrayList;
import java.util.List;
// 풀이수준 : B
class Solution {
    public int[] solution(int brown, int yellow) {
        int surface = brown + yellow;

        List<Square> devisor = getDevisor(surface);
        for (Square square : devisor) {
            if (square.x * 2 + (square.y - 2) * 2 == brown) {
                return new int[]{square.y, square.x};
            }
        }
        return new int[]{};
    }

    private List<Square> getDevisor(int surface) {
        List<Square> squares = new ArrayList<>();
        for (int i = 3; i < surface - 2; i++) {
            if (surface % i == 0) {
                squares.add(new Square(i, surface / i));
            }
        }

        return squares;
    }

    public class Square {
        int x;
        int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}