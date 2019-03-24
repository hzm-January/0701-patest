package patest.level.base.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/3/24 22:03
 * Modified By:
 * Description：
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>(100);
        hashMap.put(1, new LinkedList<>());
        hashMap.put(2, new LinkedList<>());
        hashMap.put(3, new LinkedList<>());
        hashMap.put(4, new LinkedList<>());
        hashMap.put(7, new LinkedList<>());
        hashMap.put(6, new LinkedList<>());
        hashMap.put(5, new LinkedList<>());
        for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
