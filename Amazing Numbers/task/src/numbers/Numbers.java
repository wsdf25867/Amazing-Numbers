package numbers;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers() {
        numbers = new ArrayList<>();
    }

    public Numbers(List<Number> instance) {
        numbers = instance;
    }

    public static Numbers of(long start, long count) {
        Numbers instance = new Numbers();
        for (int i = 0; i < count; i++) {
            instance.add(new Number(start + i));
        }
        return instance;
    }

    public static Numbers of(long start, long count, String property) {
        List<Number> instance = new ArrayList<>();
        long preNum = start;
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, property);
            instance.add(number);
            preNum = number.get() + 1;
        }
        return new Numbers(instance);
    }

    public static Numbers of(long start, long count, String firstProperty, String secondProperty) {
        List<Number> instance = new ArrayList<>();
        long preNum = start;
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, firstProperty, secondProperty);
            instance.add(number);
            preNum = number.get() + 1;
        }
        return new Numbers(instance);
    }

    public static Numbers of(long start, long count, String firstProperty, String secondProperty, String thirdProperty) {
        List<Number> instance = new ArrayList<>();
        long preNum = start;
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, firstProperty, secondProperty, thirdProperty);
            instance.add(number);
            preNum = number.get() + 1;
        }
        return new Numbers(instance);
    }

    public static Numbers of(String[] value) {
        int len = value.length;
        return switch (len) {
            case 2 -> of(Long.parseLong(value[0]), Long.parseLong(value[1]));
            case 3 -> of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase());
            case 4 ->
                    of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase());
            case 5 ->
                    of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase(), value[4].toUpperCase());
            case 6 ->
                    of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase(), value[4].toUpperCase(), value[5].toUpperCase());
            case 7 -> of(Long.parseLong(value[0]), Long.parseLong(value[1]), value[2].toUpperCase(), value[3].toUpperCase(), value[4].toUpperCase(), value[5].toUpperCase(), value[6].toUpperCase());
            default -> throw new IllegalStateException("Unexpected value: " + len);
        };
    }

    private static Numbers of(long parseLong, long parseLong1, String toUpperCase, String toUpperCase1, String toUpperCase2, String toUpperCase3, String toUpperCase4) {
        List<Number> instance = new ArrayList<>();
        long preNum = parseLong;
        while (instance.size() < parseLong1) {
            Number number = NumberGenerator.generate(preNum, toUpperCase, toUpperCase1, toUpperCase2, toUpperCase3, toUpperCase4);
            instance.add(number);
            preNum = number.get() + 1;
        }
        return new Numbers(instance);
    }

    private static Numbers of(long parseLong, long parseLong1, String toUpperCase, String toUpperCase1, String toUpperCase2, String toUpperCase3) {
        List<Number> instance = new ArrayList<>();
        long preNum = parseLong;
        while (instance.size() < parseLong1) {
            Number number = NumberGenerator.generate(preNum, toUpperCase, toUpperCase1, toUpperCase2, toUpperCase3);
            instance.add(number);
            preNum = number.get() + 1;
        }
        return new Numbers(instance);
    }

    private void add(Number number) {
        numbers.add(number);
    }

    public void print() {
        for (Number number : numbers) {
            number.printSimply();
        }
    }
}
