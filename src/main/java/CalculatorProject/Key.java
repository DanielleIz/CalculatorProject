package CalculatorProject;

public enum Key {
    NUM_0(0, KeyType.DIGIT, "0"),
    NUM_1(1, KeyType.DIGIT, "1"),
    NUM_2(2, KeyType.DIGIT, "2"),
    NUM_3(3, KeyType.DIGIT, "3"),
    NUM_4(4, KeyType.DIGIT, "4"),
    NUM_5(5, KeyType.DIGIT, "5"),
    NUM_6(6, KeyType.DIGIT, "6"),
    NUM_7(7, KeyType.DIGIT, "7"),
    NUM_8(8, KeyType.DIGIT, "8"),
    NUM_9(9, KeyType.DIGIT, "9"),
    PLUS(10, KeyType.OPERATOR, "+"),
    MINUS(11, KeyType.OPERATOR, "-"),
    TIMES(12, KeyType.OPERATOR, "*"),
    DIVIDE(13, KeyType.OPERATOR, "/"),
    EQUALS(14, KeyType.OPERATOR, "="),
    CLEAR(15, KeyType.CONTROL, "CLR");

    public final int code;
    public final KeyType keyType;
    public final String display;
    Key(int code, KeyType keyType, String display) {
        this.code = code;
        this.keyType = keyType;
        this.display = display;
    }
}
