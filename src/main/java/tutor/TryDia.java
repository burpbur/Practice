package tutor;

import java.util.Scanner;

public class TryDia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入高度 不可為偶數");
        int n = scanner.nextInt();

        if(n % 2 == 0){
            System.out.println("請輸入奇數");
            return;
        }
        int middle = n/ 2;

        for (int i = 0; i < n; i++) {
            int spaces = Math.abs(middle - i );
            int stars = n - 2 * spaces;

            printChar(" ", spaces);
            printChar( "*",stars);

            System.out.println();
        }
    }

    private static void printChar (String str, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }
    }
}
