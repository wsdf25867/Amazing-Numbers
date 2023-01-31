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
            preNum = number.get()+1;
        }
        return new Numbers(instance);
    }

    public static Numbers of(long start, long count, String firstProperty, String secondProperty) {
        List<Number> instance = new ArrayList<>();
        long preNum = start;
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, firstProperty, secondProperty);
            instance.add(number);
            preNum = number.get()+1;
        }
        return new Numbers(instance);
    }

    public static Numbers of(long start, long count, String firstProperty, String secondProperty, String thirdProperty) {
        List<Number> instance = new ArrayList<>();
        long preNum = start;
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, firstProperty, secondProperty, thirdProperty);
            instance.add(number);
            preNum = number.get()+1;
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
