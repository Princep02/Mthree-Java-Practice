package firstday;
public class WideningTypeCastingDemoModified {
    public static void main(String[] args) {
        // Starting with byte
        byte byteNum = 25;
        System.out.println("Original byte value: " + byteNum);
        // byte to short
        short shortNum = byteNum;
        System.out.println("byte to short: " + shortNum);
        // short to char
        // Note: This is not a direct widening conversion, as char is unsigned
        // We'll use a positive short value to demonstrate
        short shortForChar = 90;  // ASCII value for 'Z'
        char charFromShort = (char) shortForChar;
        System.out.println("short to char: " + charFromShort);
        // char to int
        int intFromChar = charFromShort;
        System.out.println("char to int: " + intFromChar);
        // int to long
        long longNum = intFromChar;
        System.out.println("int to long: " + longNum);
        // long to float
        float floatNum = longNum;
        System.out.println("long to float: " + floatNum);
        // float to double
        double doubleNum = floatNum;
        System.out.println("float to double: " + doubleNum);
        // Demonstrating multiple steps of widening in one assignment
        int largeInt = 654321;
        double doubleFromInt = largeInt;
        System.out.println("int directly to double: " + doubleFromInt);
        // Demonstrating widening in expressions
        byte smallByte = 15;
        short mediumShort = 150;
        int sum = smallByte + mediumShort;  // byte and short are promoted to int
        System.out.println("Result of byte + short (as int): " + sum);
        // Widening with literals
        int bigNum = 1_500_000_000;  // 1.5 billion
        long largeResult = bigNum * 5L;  // Result is too large for int, so it's widened to long
        System.out.println("Large calculation result (as long): " + largeResult);
        // Demonstrating potential loss of precision
        long preciseLong = 987654321987654321L;
        float lessPreciseFloat = preciseLong;  // Potential loss of precision
        System.out.println("Long to float (potential precision loss): " + lessPreciseFloat);
    }
}
