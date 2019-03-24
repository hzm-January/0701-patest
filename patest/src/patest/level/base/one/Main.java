package patest.level.base.one;



/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 10:19
 * Modified By:
 * Description：
 * 1001 害死人不偿命的(3n+1)猜想 （15 分)
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = stepNum(n);
        System.out.println(num);
    }

    private static int stepNum(int n) {
        if (n <= 0 || n > 1000) {
            throw new IllegalArgumentException("the param is error");
        }
        int num = 0;
        while (n != 1) {
            if (n % 2 != 0) {
                n = (3 * n + 1);
            }
            n = n >> 1;
            num++;
        }
        return num;
    }
}
