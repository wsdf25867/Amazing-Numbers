package numbers;

public class NumberGenerator {

    public static Number generate(Long start, String property) {
        for (long i = start; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(property).check(i)) {
                return new Number(i);
            }
        }
        return null;
    }

    public static Number generate(long start, String firstProperty, String secondProperty) {
        for (long i = start; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(firstProperty).check(i) && Property.valueOf(secondProperty).check(i)) {
                return new Number(i);
            }
        }
        return null;
    }

    public static Number generate(long start, String firstProperty, String secondProperty, String thirdProperty) {
        for (long i = start; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(firstProperty).check(i) &&
                    Property.valueOf(secondProperty).check(i) &&
                    Property.valueOf(thirdProperty).check(i)) {
                return new Number(i);
            }
        }
        return null;
    }

    public static Number generate(long preNum, String toUpperCase, String toUpperCase1, String toUpperCase2, String toUpperCase3) {
        for (long i = preNum; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(toUpperCase).check(i) &&
                    Property.valueOf(toUpperCase1).check(i) &&
                    Property.valueOf(toUpperCase2).check(i) &&
                    Property.valueOf(toUpperCase3).check(i)
            ) {
                return new Number(i);
            }
        }
        return null;
    }

    public static Number generate(long preNum, String toUpperCase, String toUpperCase1, String toUpperCase2, String toUpperCase3, String toUpperCase4) {
        for (long i = preNum; i < Long.MAX_VALUE; i++) {
            if (Property.valueOf(toUpperCase).check(i) &&
                    Property.valueOf(toUpperCase1).check(i) &&
                    Property.valueOf(toUpperCase2).check(i) &&
                    Property.valueOf(toUpperCase3).check(i) &&
                    Property.valueOf(toUpperCase4).check(i)
            ) {
                return new Number(i);
            }
        }
        return null;
    }
}
