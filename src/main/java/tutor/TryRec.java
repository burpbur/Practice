package tutor;

import java.util.Scanner;

public class TryRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "請輸入高");
        System.out.println( "請輸入寬");
        int height = scanner.nextInt();
        int width = scanner.nextInt();

        for (int i = 0; i<height; i++){
            printChar("*", width);
            System.out.println();

        }

    }

    private static void printChar(String str, int count){
        for (int i =0 ; i< count ; i++){
            System.out.print(str);
        }
    }
}
