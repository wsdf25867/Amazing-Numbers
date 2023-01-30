package numbers;

public class NumberGenerator {

    public static Number generate(Long start, String property) {
        switch (property) {
            case "even": case "EVEN":
                return makeEven(start);
            case "odd": case "ODD":
                return makeOdd(start);
            case "buzz": case "BUZZ":
                return makeBuzz(start);
            case "duck": case "DUCK":
                return makeDuck(start);
            case "palindromic": case "PALINDROMIC":
                return makePalindromic(start);
            case "gapful": case "GAPFUL":
                return makeGapful(start);
            case "spy": case "SPY":
                return makeSpy(start);
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
        if (value % tempLong == 0) {
            return true;
        } else {
            return false;
        }
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
}
