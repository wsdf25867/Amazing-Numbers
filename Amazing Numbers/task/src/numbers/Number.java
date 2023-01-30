package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Number {
    private final long value;
    private final boolean isEven;
    private final boolean isOdd;
    private final boolean isBuzz;
    private final boolean isDuck;
    private final boolean isPalindromic;
    private final boolean isGapful;
    private final boolean isSpy;

    public Number(long value) {
        this.value = value;
        this.isEven = value % 2 == 0;
        this.isOdd = !isEven;
        this.isBuzz = value % 10 == 7 || value % 7 == 0;
        this.isDuck = String.valueOf(this.value).contains("0");
        this.isPalindromic = isPalindromic();
        this.isGapful = isGapful();
        this.isSpy = isSpy();
    }
    private boolean isSpy() {
        String[] splitValue = String.valueOf(this.value).split("");
        long sum = 0;
        long mul = 1;
        for (String s : splitValue) {
            sum += Long.parseLong(s);
            mul *= Long.parseLong(s);
        }
        return sum == mul;
    }

    private boolean isGapful() {
        if (this.value < 100) {
            return false;
        }
        String temp = String.valueOf(String.valueOf(this.value).charAt(0)) + value % 10;
        long tempLong = Long.parseLong(temp);
        if (value % tempLong == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPalindromic() {
        String number = String.valueOf(this.value);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public void print() {
        System.out.printf("""
                Properties of %d
                buzz: %b
                duck: %b
                palindromic: %b
                gapful: %b
                spy: %b
                even: %b
                odd: %b
                                    
                """, value, isBuzz, isDuck, isPalindromic, isGapful, isSpy,isEven, isOdd);
    }

    public void printSimply() {
        List<String> array = new ArrayList<>();
        if (isBuzz) {
            array.add("buzz");
        }
        if (isDuck) {
            array.add("duck");
        }
        if (isPalindromic) {
            array.add("palindromic");
        }
        if (isGapful) {
            array.add("gapful");
        }
        if (isSpy) {
            array.add("spy");
        }
        if (isEven) {
            array.add("even");
        } else {
            array.add("odd");
        }
        String result = String.join(", ", array);
        System.out.printf("%d is %s\n", value, result);
    }

    public Long get() {
        return this.value;
    }
}
