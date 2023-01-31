package numbers;

public class NumberGenerator {

    public static Number generate(Long start, String property) {
        return switch (property) {
            case "even", "EVEN" -> makeEven(start);
            case "odd", "ODD" -> makeOdd(start);
            case "buzz", "BUZZ" -> makeBuzz(start);
            case "duck", "DUCK" -> makeDuck(start);
            case "palindromic", "PALINDROMIC" -> makePalindromic(start);
            case "gapful", "GAPFUL" -> makeGapful(start);
            case "spy", "SPY" -> makeSpy(start);
            case "square", "SQUARE" -> makeSquare(start);
            case "sunny", "SUNNY" -> makeSunny(start);
            default -> null;
        };
    }

    private static Number makeSunny(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (isSunny(value)) return new Number(value);
        }
        return null;
    }

    private static Number makeSquare(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (isSquare(value)) return new Number(value);
        }
        return null;
    }

    private static Number makeSpy(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (isSpy(value)) return new Number(value);
        }
        return null;
    }

    private static Number makeGapful(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (isGapful(value)) return new Number(value);
        }
        return null;
    }

    private static Number makePalindromic(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (isPalindromic(value)) return new Number(value);
        }
        return null;
    }

    private static Number makeBuzz(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (value % 10 == 7 || value % 7 == 0) return new Number(value);
        }
        return null;
    }

    private static Number makeDuck(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (String.valueOf(value).contains("0")) return new Number(value);
        }
        return null;
    }

    private static Number makeOdd(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (value % 2 == 1) return new Number(value);
        }
        return null;
    }

    private static Number makeEven(Long start) {
        for (long value = start; value < Long.MAX_VALUE; value++) {
            if (value % 2 == 0) return new Number(value);
        }
        return null;
    }

    private static boolean isSunny(long value) {
        return Math.sqrt(value + 1) % 1 == 0;
    }

    private static boolean isSquare(long value) {
        return Math.sqrt(value) % 1 == 0;
    }

    private static boolean isSpy(long value) {
        String[] splitValue = String.valueOf(value).split("");
        long sum = 0;
        long mul = 1;
        for (String s : splitValue) {
            sum += Long.parseLong(s);
            mul *= Long.parseLong(s);
        }
        return sum == mul;
    }

    private static boolean isGapful(long value) {
        if (value < 100) {
            return false;
        }
        String temp = String.valueOf(String.valueOf(value).charAt(0)) + value % 10;
        long tempLong = Long.parseLong(temp);
        return value % tempLong == 0;
    }

    private static boolean isPalindromic(long value) {
        String number = String.valueOf(value);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static Number generate(long start, String firstProperty, String secondProperty) {
        for (long i = start; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(firstProperty).check(i) && Property.valueOf(secondProperty).check(i)) {
                return new Number(i);
            }
        }
        return null;
    }
}
