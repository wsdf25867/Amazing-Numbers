package numbers;

import java.util.function.Predicate;

public enum Property {
    BUZZ("buzz", "-buzz", value -> value % 10 == 7 || value % 7 == 0),
    DUCK("duck", "-duck", value -> String.valueOf(value).contains("0")),
    PALINDROMIC("palindromic",
            "-palindromic", value -> {
        String number = String.valueOf(value);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }),
    GAPFUL("gapful",
            "-gapful", value -> {
        if (value < 100) {
            return false;
        }
        String temp = String.valueOf(String.valueOf(value).charAt(0)) + value % 10;
        long tempLong = Long.parseLong(temp);
        return value % tempLong == 0;
    }),
    SPY("spy",
            "-spy", value -> {
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
    EVEN("even", "-even", value -> value % 2 == 0),
    ODD("odd", "-odd", value -> value % 2 == 1),
    SQUARE("square", "-square", value -> Math.sqrt(value) % 1 == 0),
    SUNNY("sunny", "-sunny", value -> Math.sqrt(value + 1) % 1 == 0),
    JUMPING("jumping",
            "-jumping", value -> {
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
    }),
    HAPPY("happy",
            "-happy", value -> {
        String strValue = String.valueOf(value);
        long sum = 0;
        while (true) {
            String[] split = strValue.split("");
            for (String s : split) {
                sum += Math.pow(Long.parseLong(s), 2);
            }
            if (sum == 1) {
                return true;
            }
            if (sum == 4) {
                return false;
            }
            strValue = String.valueOf(sum);
            sum = 0;
        }
    }),
    SAD("sad", "-sad", value -> !Property.HAPPY.check(value));


    private final String lowerCase;
    private final String opposite;
    private final Predicate<Long> predicate;

    Property(String lowerCase, String opposite, Predicate<Long> predicate) {
        this.lowerCase = lowerCase;
        this.opposite = opposite;
        this.predicate = predicate;
    }

    public static boolean contains(String property) {
        for (Property value : Property.values()) {
            if (property.equals(value.name()) ||
                    property.equals(value.lowerCase) ||
                    property.equals(value.opposite)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(Long value) {
        return predicate.test(value);
    }

    public boolean checkNot(Long value) {
        return !predicate.test(value);
    }
}
