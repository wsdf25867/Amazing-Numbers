package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.printf("""
                Welcome to Amazing Numbers!
                                
                Supported requests:
                - enter a natural number to know its properties;\s
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and a property to search for;
                - two natural numbers and two properties to search for;
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
            if (value.length == 5) {
                Numbers numbers = Numbers.of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase(), value[4].toUpperCase());
                numbers.print();
            }else if (value.length == 4) {
                Numbers numbers = Numbers.of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase());
                numbers.print();
            } else if (value.length == 3) {
                Numbers numbers = Numbers.of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase());
                numbers.print();
            } else if (value.length == 2) {
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
            System.out.print("The first parameter should be a natural number or zero.\n");
            return false;
        }
        if (value.length == 2 && !isNatural(value[1])) {
            System.out.println("The second parameter should be a natural number.\n");
            return false;
        }
        if (value.length == 3 && !Property.contains(value[2])) {
            System.out.printf("The property [%s] is wrong.\n", value[2]);
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
            return false;
        }
        if (value.length == 4) {
            List<String> array = new ArrayList<>();
            if (!Property.contains(value[2])) array.add(value[2]);
            if (!Property.contains(value[3])) array.add(value[3]);
            if (array.size() == 2) {
                System.out.printf("The properties [%s] are wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
                return false;
            } else if (array.size() == 1) {
                System.out.printf("The property [%s] is wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
                return false;
            } else {
                String master = value[2].toUpperCase() + value[3].toUpperCase();
                if (master.contains("ODD") && master.contains("EVEN") ||
                        master.contains("SUNNY") && master.contains("SQUARE") ||
                        master.contains("DUCK") && master.contains("SPY")) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, value[2], value[3]);
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNatural(String value) {
        return Pattern.compile("[0-9]")
                .matcher(value).find() && Long.parseLong(value) > 0;
    }
}
