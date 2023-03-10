package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
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
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING HAPPY, SAD]");
            return false;
        }
        if (value.length >= 4) {
            List<String> array = new ArrayList<>();
            for (int i = 2; i < value.length; i++) {
                if (!Property.contains(value[i])) array.add(value[i]);
            }
            if (array.size() >= 2) {
                System.out.printf("The properties [%s] are wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING HAPPY, SAD]");
                return false;
            } else if (array.size() == 1) {
                System.out.printf("The property [%s] is wrong.\n", String.join(", ", array));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING HAPPY, SAD]");
                return false;
            } else {
                                        int len = Property.values().length;
                int[] positive = new int[len];
                int[] negative = new int[len];
                for (int i = 2; i < value.length; i++) {
                    String temp = value[i].toUpperCase();
                    for (int j = 0; j < len; j++) {
                        if (temp.startsWith("-")) {
                            if (Objects.equals(temp.substring(1), Property.values()[j].name())) {
                                negative[j]++;
                                break;
                            }
                        } else {
                            if (Objects.equals(temp, Property.values()[j].name())) {
                                positive[j]++;
                                break;
                            }
                        }
                    }
                }

                for (int i = 0; i < len; i++) {
                    if (positive[i] == negative[i] && positive[i] > 0 && negative[i] > 0) {
                        System.out.printf("""
                                The request contains mutually exclusive properties: [%s, %s]
                                There are no numbers with these properties.
                                                            
        """, "-" + Property.values()[i], Property.values()[i]);
                        return false;
                    }
                }
                if (positive[5] == positive[6] && positive[5] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, Property.values()[5], Property.values()[6]);
                    return false;
                }
                if (positive[7] == positive[8] && positive[7] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, Property.values()[7], Property.values()[8]);
                    return false;
                }
                if (positive[1] == positive[4] && positive[1] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, Property.values()[1], Property.values()[4]);
                    return false;
                }
                if (positive[10] == positive[11] && positive[10] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, Property.values()[10], Property.values()[11]);
                    return false;
                }
                if (negative[5] == negative[6] && negative[5] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, "-" + Property.values()[5], "-" + Property.values()[6]);
                    return false;
                }
                if (negative[7] == negative[8] && negative[7] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, "-" + Property.values()[7], "-" + Property.values()[8]);
                    return false;
                }
                if (negative[1] == negative[4] && negative[1] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, "-" + Property.values()[1], "-" + Property.values()[4]);
                    return false;
                }
                if (negative[10] == negative[11] && negative[10] > 0) {
                    System.out.printf("""
                            The request contains mutually exclusive properties: [%s, %s]
                            There are no numbers with these properties.
                                                        
                            """, "-" + Property.values()[10], "-" + Property.values()[11]);
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
