package game.validation;

import java.util.Scanner;

public class InputData {
    public static Scanner scanner = new Scanner(System.in);

    public static int checkInt() {
        int number;
        while (!scanner.hasNextInt()) {
            System.out.println("You entered an invalid number!");
            System.out.print("Re-enter:");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }

    public static String InputString() {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        return str;
    }

}

