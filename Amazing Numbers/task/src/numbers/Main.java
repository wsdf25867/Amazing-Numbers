package numbers;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.printf("""
                Welcome to Amazing Numbers!
                
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.
                
                """);
        while (true) {
            System.out.printf("Enter a request: ");
            String[] value = scanner.nextLine().split(" ");
            if ("0".equals(value[0])) break;
            if (!validate(value)) {
                continue;
            }
            if (value.length == 3) {
                Numbers numbers = Numbers.of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2]);

            }
            if (value.length == 2) {
                Numbers numbers = Numbers.of(Long.parseLong(value[0]), Long.parseLong(value[1]));
                numbers.print();
            } else {
                Number number = new Number(Long.parseLong(value[0]));
                number.print();
            }
        }

        System.out.println("Goodbye!");
    }

    private static boolean validate(String[] value) {
        if (!isNatural(value[0])) {
            System.out.printf("The first parameter should be a natural number or zero.\n");
            return false;
        }
        if (value.length ==2 && !isNatural(value[1])) {
            System.out.println("The second parameter should be a natural number.\n");
            return false;
        }
        if (value.length == 3 && !Property.contains(value[2])) {
            System.out.printf("The property [%s] is wrong.\n",value[2]);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
            return false;
        }
        return true;
    }

    private static boolean isNatural(String value) {
        return Pattern.compile("[0-9]")
                .matcher(value).find() && Long.parseLong(value) > 0;
    }
}
