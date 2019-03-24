package patest.level.base.two;

import java.util.Scanner;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 10:40
 * Modified By:
 * Description： 题号1002，分数20，耗时111ms，内存16776KB
 * 1002 写出这个数 （20 分)
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 * <p>
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10^100
 * <p>
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
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
