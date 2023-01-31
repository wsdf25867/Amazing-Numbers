package numbers;

import java.util.ArrayList;
import java.util.List;
public class Number {
    private final long value;
    private final boolean isEven;
    private final boolean isOdd;
    private final boolean isBuzz;
    private final boolean isDuck;
    private final boolean isPalindromic;
    private final boolean isGapful;
    private final boolean isSpy;
    private final boolean isSquare;
    private final boolean isSunny;
    private final boolean isJumping;

    public Number(long value) {
        this.value = value;
        this.isEven = Property.EVEN.check(this.value);
        this.isOdd = Property.ODD.check(this.value);
        this.isBuzz = Property.BUZZ.check(this.value);
        this.isDuck = Property.DUCK.check(this.value);
        this.isPalindromic = Property.PALINDROMIC.check(this.value);
        this.isGapful = Property.GAPFUL.check(this.value);
        this.isSpy = Property.SPY.check(this.value);
        this.isSquare = Property.SQUARE.check(this.value);
        this.isSunny = Property.SUNNY.check(this.value);
        this.isJumping = Property.JUMPING.check(this.value);
    }
    public void print() {
        System.out.printf("""
                Properties of %d
                buzz: %b
                duck: %b
                palindromic: %b
                gapful: %b
                spy: %b
                square: %b
                sunny: %b
                jumping: %b
                even: %b
                odd: %b
                                    
                """, value, isBuzz, isDuck, isPalindromic, isGapful, isSpy, isSquare, isSunny, isJumping, isEven, isOdd);
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
        if (isSquare) {
            array.add("square");
        }
        if (isSunny) {
            array.add("sunny");
        }
        if (isJumping) {
            array.add("jumping");
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
