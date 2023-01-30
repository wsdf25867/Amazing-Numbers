package numbers;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers = new ArrayList<>();

    private Numbers() {
    }

    public static Numbers of(long start, long count) {
        Numbers instance = new Numbers();
        for (int i = 0; i < count; i++) {
            instance.add(new Number(start + i));
        }
        return instance;
    }

    public static Numbers of(long start, long count, String property) {
        Numbers instance = new Numbers();

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
