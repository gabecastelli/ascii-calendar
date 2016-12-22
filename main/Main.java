package main;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Gabe Castelli
 * Prints calendar given a year
 * Uses tabs of length 8
 */ 

public class Main {
    public static void main(String[] args) {
        final String PATTERN = "\\d{4,}";
        boolean again;
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.print("Enter year: ");
            String input = stdin.next();
            while (!(Pattern.compile(PATTERN).matcher(input).matches()) || Long.parseLong(input) < 1582) {
                System.out.println("Year can't be less than 1582");
                System.out.print("Enter year: ");
                input = stdin.next();
            }
            Calendar c = new Calendar(Long.parseLong(input));
            System.out.print(c);
            System.out.print("Show another calendar? (y / n): ");
            input = stdin.next();
            while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                System.out.print("Please enter y or n: ");
                input = stdin.next();
            } 
            again = input.equalsIgnoreCase("y");
        } while (again);
    }
}

