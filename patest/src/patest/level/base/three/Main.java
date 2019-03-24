package patest.level.base.three;

import java.util.Scanner;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 15:26
 * Modified By:
 * Description：
 * 1003 我要通过！ （20 分)
 *
 * 若XPYTZ
 * 当X!=0时，Y=X*Z 即可满足条件
 * 当X==Y==0时，只要Y>=1即可满足条件
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
            if (check(array[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean check(String str) {
        if (!str.contains("P") || !str.contains("T")) {
            return false;
        }
        int p = str.indexOf("P");
        int t = str.lastIndexOf("T");
        if (t < p) {
            return false;
        }
        String startToP = str.substring(0, p);
        String pTot = str.substring(p + 1, t);
        String tToEnd = str.substring(t + 1, str.length());
        if (!validate(startToP, false) || !validate(pTot, true) || !validate(tToEnd, false)) {
            return false;
        }
        int startToPLength = startToP.length();
        int pToTLength = pTot.length();
        int tToEndLength = tToEnd.length();
        if (startToPLength == 0 && tToEndLength == 0) {
            return true;
        }
        if (tToEndLength == pToTLength * startToPLength) {
            return true;
        }
        return false;

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
