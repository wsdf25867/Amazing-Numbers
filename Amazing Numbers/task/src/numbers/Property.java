package numbers;

public enum Property {
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    EVEN,
    ODD;

    public static boolean contains(String property) {
        for (Property value : Property.values()) {
            if (property.equals(value.name())) {
                return true;
            }
        }
        return false;
    }
}
