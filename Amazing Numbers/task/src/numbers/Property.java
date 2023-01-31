package numbers;

import java.util.function.Predicate;

public enum Property {
    BUZZ("buzz", value -> value % 10 == 7 || value % 7 == 0),
    DUCK("duck", value -> String.valueOf(value).contains("0")),
    PALINDROMIC("palindromic",
            value -> {
                String number = String.valueOf(value);
                for (int i = 0; i < number.length() / 2; i++) {
                    if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                        return false;
                    }
                }
                return true;
            }),
    GAPFUL("gapful",
            value -> {
                if (value < 100) {
                    return false;
                }
                String temp = String.valueOf(String.valueOf(value).charAt(0)) + value % 10;
                long tempLong = Long.parseLong(temp);
                return value % tempLong == 0;
            }),
    SPY("spy",
            value -> {
                long sum = 0;
                long product = 1;
                long lastdigit;
                while (value > 0) {
                    lastdigit = value % 10;
                    sum = sum + lastdigit;
                    product = product * lastdigit;
                    value = value / 10;
                }
                return sum == product;
            }),
    EVEN("even", value -> value % 2 == 0),
    ODD("odd", value -> value % 2 == 1),
    SQUARE("square", value -> Math.sqrt(value) % 1 == 0),
    SUNNY("sunny", value -> Math.sqrt(value + 1) % 1 == 0),
    JUMPING("jumping",
            value -> {
                long digit;
                long temp;
                while (value != 0) {
                    if (value <= 10) return true;
                    digit = value % 10;
                    temp = (value / 10) % 10;
                    if (Math.abs(digit - temp) != 1) return false;
                    value /= 10;
                }
                return true;
            });

    private final String lowerCase;
    private final Predicate<Long> predicate;

    Property(String lowerCase, Predicate<Long> predicate) {
        this.lowerCase = lowerCase;
        this.predicate = predicate;
    }

    public static boolean contains(String property) {
        for (Property value : Property.values()) {
            if (property.equals(value.name()) || property.equals(value.lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(Long value) {
        return predicate.test(value);
    }
}
