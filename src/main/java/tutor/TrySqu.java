package tutor;

import java.util.Scanner;

public class TrySqu {
    public static void main(String[] args) {
        //創建scanner對象 並 接收控制台輸入
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入高度");
        //獲取輸入的值
        int n = scanner.nextInt();

        //根據輸入打印
        for (int i = 0 ; i< n ; i++){
            printChar("*" , n);
            System.out.println();
        }
    }
    //印出指定字符方法與方法體邏輯
    private static void printChar(String str, int count ){
        for(int i = 0 ; i < count ; i++){
            System.out.print(str);
        }
    }
}
