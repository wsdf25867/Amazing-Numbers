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
}
