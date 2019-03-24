package patest.level.base.four;

import java.util.Scanner;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 20:04
 * Modified By:
 * Description：
 * 1004 成绩排名 （20 分)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        if (n <= 0) {
            throw new IllegalArgumentException(" the param is error");
        }
        String[] nameAndNos = new String[n];
        int[] scores = new int[n];
        int p = 0;
        while (p < n) {
            String info = scanner.nextLine();
            String[] infoDetails = info.split(" ");
            String name = infoDetails[0];
            String id = infoDetails[1];
            int score = Integer.valueOf(infoDetails[2]);
            if (name.length() > 10 || id.length() > 10 || score < 0 || score > 100) {
                throw new IllegalArgumentException(" the param is error");
            }
            nameAndNos[p] = name.concat(" ").concat(id);
            scores[p] = score;
            p++;
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[max] < scores[i]) {
                max = i;
            }
            if (scores[min] > scores[i]) {
                min = i;
            }
        }
        System.out.println(nameAndNos[max]);
        System.out.println(nameAndNos[min]);
    }
}
