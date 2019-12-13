import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    public static void main(String args[]) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        Map<Integer, StringBuilder> map = new HashMap<>();
        int[] alts = new int[numRows + numRows - 2];
        int j = 0;
        int z = 1;
        for (int i = 0; i < alts.length; i++) {
            alts[i] = j;
            if (j < numRows - 1 && i < numRows) {
                j++;
            } else if (j == numRows - 1) {
                j = numRows - 2;
            } else {
                j--;
            }
        }
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            map.get(alts[j]).append(s.charAt(i));
            j++;
            if (j == alts.length) {
                j = 0;
            }
        }
        for (int i = 0; i < map.size(); i++) {
            result.append(map.get(i).toString());
        }
        return result.toString();
    }
}
