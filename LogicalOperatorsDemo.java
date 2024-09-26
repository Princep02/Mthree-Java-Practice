
public class LogicalOperatorsDemo {
    public static void main(String[] args) {
        // Updated boolean variables
        boolean x = true;
        boolean y = false;

        System.out.println("1. Basic Logical Operations:");
        System.out.println("   AND: true && true = " + (x && x));
        System.out.println("   AND: true && false = " + (x && y));
        System.out.println("   AND: false && true = " + (y && x));
        System.out.println("   AND: false && false = " + (y && y));
        System.out.println("   OR: true || true = " + (x || x));
        System.out.println("   OR: true || false = " + (x || y));
        System.out.println("   OR: false || true = " + (y || x));
        System.out.println("   OR: false || false = " + (y || y));
        System.out.println("   NOT: !true = " + (!x));
        System.out.println("   NOT: !false = " + (!y));

        System.out.println("\n2. Short-circuit Evaluation:");
        System.out.println("   false && (5/0 > 0) = " + (y && (5/0 > 0))); // No ArithmeticException
        System.out.println("   true || (5/0 > 0) = " + (x || (5/0 > 0))); // No ArithmeticException

        System.out.println("\n3. Operator Precedence:");
        System.out.println("   true || false && false = " + (x || y && y)); // && has higher precedence
        System.out.println("   (true || false) && false = " + ((x || y) && y)); // Parentheses change precedence

        System.out.println("\n4. Combining with Comparison Operators:");
        int a = 3, b = 7;
        System.out.println("   (a < b) && (b > 0) = " + ((a < b) && (b > 0)));
        System.out.println("   (a > b) || (b < 20) = " + ((a > b) || (b < 20)));

        System.out.println("\n5. Complex Conditions:");
        boolean p = true, q = false, r = false;
        System.out.println("   (p && q) || (p && r) = " + ((p && q) || (p && r)));
        System.out.println("   p && (q || r) = " + (p && (q || r)));
        System.out.println("   !p || (q && !r) = " + (!p || (q && !r)));

        System.out.println("\n6. Bitwise vs. Logical Operators:");
        System.out.println("   true & false = " + (x & y)); // Bitwise AND
        System.out.println("   true | false = " + (x | y)); // Bitwise OR
        System.out.println("   true ^ false = " + (x ^ y)); // Bitwise XOR

        System.out.println("\n7. Short-circuit vs. Non-short-circuit:");
        int i = 0;
        boolean result1 = (y && (++i > 0)); // i is not incremented
        boolean result2 = (y & (++i > 0));  // i is incremented
        System.out.println("   Short-circuit AND result: " + result1 + ", i = " + i);
        System.out.println("   Non-short-circuit AND result: " + result2 + ", i = " + i);

        System.out.println("\n8. Logical Operators with Non-boolean Operands:");
        System.out.println("   (2 < 4) && (6 < 8) = " + ((2 < 4) && (6 < 8)));
        System.out.println("   ('x' < 'y') || ('p' > 'q') = " + (('x' < 'y') || ('p' > 'q')));

        System.out.println("\n9. Logical Operators in Control Structures:");
        if (x && !y) {
            System.out.println("   This will be printed.");
        }
        
        int j = 0;
        while (j < 2 && x) {
            System.out.println("   j = " + j);
            j++;
        }

        System.out.println("\n10. Logical Operators with Method Calls:");
        System.out.println("   isPositive(10) && isEven(8) = " + (isPositive(10) && isEven(8)));
        System.out.println("   isPositive(-1) || isEven(9) = " + (isPositive(-1) || isEven(9)));

        System.out.println("\n11. Logical Operators with Null Checks:");
        String message = null;
        System.out.println("   (message != null) && (message.length() > 0) = " + ((message != null) && (message.length() > 0))); // Safe null check

        System.out.println("\n12. Using Logical Operators for Conditional Assignment:");
        int result = x ? 10 : 0;
        System.out.println("   result = " + result);

        System.out.println("\n13. Logical Operators in Lambda Expressions:");
        java.util.function.Predicate<Integer> isPositiveAndOdd = n -> n > 0 && n % 2 != 0;
        System.out.println("   Is 7 positive and odd? " + isPositiveAndOdd.test(7));
        System.out.println("   Is 8 positive and odd? " + isPositiveAndOdd.test(8));
    }

    private static boolean isPositive(int n) {
        return n > 0;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
