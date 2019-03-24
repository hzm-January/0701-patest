package patest.level.base.three;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 15:26
 * Modified By:
 * Description：
 * <p>
 * 1003 我要通过！ （20 分)
 * “答案正确”是自动判题系统给出的最令人欢喜的回复。本题属于 PAT 的“答案正确”大派送 —— 只要读入的字符串满足下列条件，系统就输出“答案正确”，否则输出“答案错误”。
 * <p>
 * 得到“答案正确”的条件是：
 * <p>
 * 字符串中必须仅有 P、 A、 T这三种字符，不可以包含其它字符；
 * 任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
 * 如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a、 b、 c 均或者是空字符串，或者是仅由字母 A 组成的字符串。
 * 现在就请你为 PAT 写一个自动裁判程序，判定哪些字符串是可以获得“答案正确”的。
 * <p>
 * 输入格式：
 * 每个测试输入包含 1 个测试用例。第 1 行给出一个正整数 n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过 100，且不包含空格。
 * <p>
 * 输出格式：
 * 每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出 YES，否则输出 NO。
 * <p>
 * 输入样例：
 * 8
 * PAT
 * PAAT
 * AAPATAA
 * AAPAATAAAA
 * xPATx
 * PT
 * Whatever
 * APAAATAA
 * 输出样例：
 * YES
 * YES
 * YES
 * YES
 * NO
 * NO
 * NO
 * NO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 0 || num >= 10) {
            throw new IllegalArgumentException("the param is error");
        }
        String[] array = new String[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(check(array[i]));
        }
//        String str = "sdac";
//        String substring = str.substring(2, 4);
//        System.out.println(substring);
    }

    private static boolean check(String str) {
        if (!str.contains("P") || !str.contains("T")) {
            return false;
        }
        int p = str.indexOf("P");
        int t = str.lastIndexOf("T");
        String startToP = str.substring(0, p);
        String pTot = str.substring(p + 1, t);
        String tToEnd = str.substring(t + 1, str.length());
        if (!validate(startToP, false) || !validate(pTot, true) || !validate(tToEnd, false)) {
            return false;
        }
        int startToPLength = startToP.length();
        int pToTLength = pTot.length();
        int tToEndLength = tToEnd.length();
        if (pToTLength - 1 > startToPLength) {
            if (startToPLength  == 0 && tToEndLength == 0) {
                return true;
            }
            return false;
        }
        if (pToTLength == 1) {
            if (startToPLength == tToEndLength) {
                return true;
            } else {
                return false;
            }
        } else {
            if (startToPLength == 0 && tToEndLength == 0) {
                return true;
            }else if (startToPLength << 1 == tToEndLength) {
                return true;
            } else {
                return false;
            }
        }

    }

    private static boolean validate(String string, boolean isMiddle) {
        if (string.length() == 0) {
            if (isMiddle) {
                return false;
            }
            return true;
        }
        String[] chars = string.split("");
        for (int i = 0; i < chars.length; i++) {
            if (!"A".equals(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
