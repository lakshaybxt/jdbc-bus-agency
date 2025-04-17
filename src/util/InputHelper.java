package util;

import java.util.Scanner;

public class InputHelper {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
            System.out.println(prompt);
        }
        return scanner.nextInt();
    }

    public static String readString(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public static String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static boolean readBoolean(String prompt) {
        System.out.println(prompt + " (true/ false): ");
        while(!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true or false");
            scanner.next();
            System.out.println(prompt);
        }
        return scanner.nextBoolean();
    }

    public static double realDouble(String prompt) {
        System.out.println(prompt); {
            while(!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                System.out.println(prompt);
            }
            return scanner.nextDouble();
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
