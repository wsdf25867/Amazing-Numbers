package numbers;

public class NumberGenerator {
    public static Number generate(long preNum, String... properties) {
        for (long i = preNum; i < Long.MAX_VALUE; i++) {
            int count = 0;
            for (String property : properties) {
                if (property.startsWith("-")) {
                    if (Property.valueOf(property.substring(1)).checkNot(i))count++;
                } else {
                    if (Property.valueOf(property.toUpperCase()).check(i)) count++;
                }
            }
            if (count == properties.length) return new Number(i);
        }
        return null;
    }
}
