package gr.aueb.cf.projects;

import java.util.Scanner;

public class ProjectCh5App {
        final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        String response;

        do {
            printMenu();
            response = getChoice();
            try {
                if (response.matches("[qQ]")) {
                    quit = true;
                } else {
                    printOnChoice(response);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Choice");
            }
        } while (!quit);
    }

    public static void printMenu() {
        System.out.println("Please select one of the following: ");
        System.out.println("1. Print H");
        System.out.println("2. Print V");
        System.out.println("3. Print H & V");
        System.out.println("4. Print H & V ascending");
        System.out.println("5. Print H & V descending");
        System.out.println("Press Q or q to quit");
    }

    public static String getChoice() {
        return in.nextLine().trim();
    }

    public static void  printStarsH(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }

        System.out.println();
    }

    public static void  printStarsV(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("*");
        }

        System.out.println();
    }

    public static void printHV(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(n);
        }
    }

    public static void printHVAsc(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(i);
        }
    }

    public static void printHVDesc(int n) {
        for (int i = n; i <= 1; i--) {
            printStarsH(i);
        }
    }

    public static void printOnChoice(String s) throws IllegalArgumentException {
        int choice;
        int n = 0;

        try {
            choice = Integer.parseInt(s);
            if ((choice) >= 1 && (choice <= 5)) {
                System.out.println("Please insert the number of stars");
                n = Integer.parseInt(getChoice());
            }
            switch (choice) {
                case 1:
                    printStarsH(n);
                    break;
                case 2:
                    printStarsV(n);
                    break;
                case 3:
                    printHVAsc(n);
                    break;
                case 4:
                    printHVAsc(n);
                    break;
                case 5:
                    printHVDesc(n);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); // Να γίνει logging σε αρχείο και να μην εκτυπώνει το exception στην οθόνη
            throw e;
        }
    }
}
