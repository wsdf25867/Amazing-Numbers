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
             if (value.length >= 2) {
                Numbers numbers = Numbers.of(value);
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
        if (value.length >= 4) {
            List<String> array = new ArrayList<>();
            for (int i = 2; i < value.length; i++) {
                if (!Property.contains(value[i])) array.add(value[i]);
            }
            if (array.size() >= 2) {
                System.out.printf("The properties [%s] are wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
                return false;
            } else if (array.size() == 1) {
                System.out.printf("The property [%s] is wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
                return false;
            } else {
                StringBuilder master = new StringBuilder();
                for (int i = 2 ; i < value.length ; i++){
                    master.append(value[i].toUpperCase());
                }
                if (master.toString().contains("ODD") && master.toString().contains("EVEN") ||
                        master.toString().contains("SUNNY") && master.toString().contains("SQUARE") ||
                        master.toString().contains("DUCK") && master.toString().contains("SPY")) {
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
