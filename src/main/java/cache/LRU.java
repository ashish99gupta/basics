package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        int threshold = 4;
        int val, count = 0;
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 30; i++) {
            val = sc.nextInt();
            if (map.get(val) == null) {
                if (count >= threshold) {
                    list.poll();
                }
            } else {
                int index = map.get(val);
                list.remove(index-1);
            }

            list.add(val);
            map.put(val, list.indexOf(val));
            list.forEach(value-> System.out.print(value+" "));
            count++;
            System.out.println();
        }
    }
}
