package tutor;

import java.util.*;

public class Try {
    public static void main(String[] args) {
        //創建ArrayList對象
        List<String> list = new ArrayList<>();
        //向list 添加元素
        list.add("A");
        list.add("D");
        list.add("C");
        list.add("E");
        list.add("B");
        //輸出尚未排序的結果
        System.out.println("Before sorting: " + list);
        //進行排序
        Collections.sort(list);
        //輸出已排序的結果
        System.out.println("After sorting: " + list);
    }
}
