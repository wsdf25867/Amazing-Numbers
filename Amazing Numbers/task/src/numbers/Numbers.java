package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;
    public Numbers(List<Number> instance) {
        numbers = instance;
    }

    public static Numbers of(String[] value) {
        List<Number> instance = new ArrayList<>();
        long preNum = Long.parseLong(value[0]);
        long count = Long.parseLong(value[1]);
        while (instance.size() < count) {
            Number number = NumberGenerator.generate(preNum, Arrays.copyOfRange(value, 2, value.length));
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
