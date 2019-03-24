package patest.level.base.two;

import java.util.Scanner;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 10:40
 * Modified By:
 * Description：
 * 1002 写出这个数 （20 分)
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sum = String.valueOf(sum(scanner.next()));
        StringBuilder result = new StringBuilder(sum.length() << 2);
        for (int i = 0; i < sum.length(); i++) {
            result.append(PinYin.match(String.valueOf(sum.charAt(i))).concat(" "));
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    private static int sum(String n) {
        int sum = 0;
        int point = 0;
        while (point < n.length()) {
            sum += Integer.valueOf(n.substring(point, point + 1));
            point++;
        }
        return sum;
    }

    public enum PinYin {
        ling("0"),
        yi("1"),
        er("2"),
        san("3"),
        si("4"),
        wu("5"),
        liu("6"),
        qi("7"),
        ba("8"),
        jiu("9");
        private String n;

        PinYin(String n) {
            this.n = n;
        }

        public static String match(String n) {
            PinYin[] values = PinYin.values();
            for (PinYin value : values) {
                if (value.n.equalsIgnoreCase(n)) {
                    return value.name();
                }
            }
            return null;
        }
    }
}
