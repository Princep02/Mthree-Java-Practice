package firstday;
public class ComprehensiveLogicalOperatorsDemo {
    public static void main(String[] args) {
        // Basic boolean variables
        boolean t = true;
        boolean f = false;

        System.out.println("1. Basic Logical Operations:");
        System.out.println("   AND: true && true = " + (t && t));
        System.out.println("   AND: true && false = " + (t && f));
        System.out.println("   AND: false && true = " + (f && t));
        System.out.println("   AND: false && false = " + (f && f));
        System.out.println("   OR: true || true = " + (t || t));
        System.out.println("   OR: true || false = " + (t || f));
        System.out.println("   OR: false || true = " + (f || t));
        System.out.println("   OR: false || false = " + (f || f));
        System.out.println("   NOT: !true = " + (!t));
        System.out.println("   NOT: !false = " + (!f));

        System.out.println("\n2. Short-circuit Evaluation:");
        System.out.println("   false && (1/0 > 0) = " + (f && (1/0 > 0))); // No ArithmeticException
        System.out.println("   true || (1/0 > 0) = " + (t || (1/0 > 0))); // No ArithmeticException

        System.out.println("\n3. Operator Precedence:");
        System.out.println("   true || false && false = " + (t || f && f)); // && has higher precedence
        System.out.println("   (true || false) && false = " + ((t || f) && f)); // Parentheses change precedence

        System.out.println("\n4. Combining with Comparison Operators:");
        int x = 5, y = 10;
        System.out.println("   (x < y) && (y > 0) = " + ((x < y) && (y > 0)));
        System.out.println("   (x > y) || (y < 20) = " + ((x > y) || (y < 20)));

        System.out.println("\n5. Complex Conditions:");
        boolean a = true, b = false, c = true;
        System.out.println("   (a && b) || (a && c) = " + ((a && b) || (a && c)));
        System.out.println("   a && (b || c) = " + (a && (b || c)));
        System.out.println("   !a || (b && !c) = " + (!a || (b && !c)));

        System.out.println("\n6. Bitwise vs. Logical Operators:");
        System.out.println("   true & false = " + (t & f)); // Bitwise AND
        System.out.println("   true | false = " + (t | f)); // Bitwise OR
        System.out.println("   true ^ false = " + (t ^ f)); // Bitwise XOR

        System.out.println("\n7. Short-circuit vs. Non-short-circuit:");
        int i = 0;
        boolean result1 = (f && (++i > 0)); // i is not incremented
        boolean result2 = (f & (++i > 0));  // i is incremented
        System.out.println("   Short-circuit AND result: " + result1 + ", i = " + i);
        System.out.println("   Non-short-circuit AND result: " + result2 + ", i = " + i);

        System.out.println("\n8. Logical Operators with Non-boolean Operands:");
        System.out.println("   (1 < 2) && (3 < 4) = " + ((1 < 2) && (3 < 4)));
        System.out.println("   ('a' < 'b') || ('c' > 'd') = " + (('a' < 'b') || ('c' > 'd')));

        System.out.println("\n9. Logical Operators in Control Structures:");
        if (t && !f) {
            System.out.println("   This will be printed.");
        }
        
        int j = 0;
        while (j < 3 && t) {
            System.out.println("   j = " + j);
            j++;
        }

        System.out.println("\n10. Logical Operators with Method Calls:");
        System.out.println("   isPositive(5) && isEven(4) = " + (isPositive(5) && isEven(4)));
        System.out.println("   isPositive(-3) || isEven(7) = " + (isPositive(-3) || isEven(7)));

        System.out.println("\n11. Logical Operators with Null Checks:");
        String str = null;
        System.out.println("   (str != null) && (str.length() > 0) = " + ((str != null) && (str.length() > 0))); // Safe null check
        // System.out.println("   (str.length() > 0) && (str != null) = " + ((str.length() > 0) && (str != null))); // This would throw NullPointerException

        System.out.println("\n12. Using Logical Operators for Conditional Assignment:");
        int value = t ? 1 : 0;
        System.out.println("   value = " + value);

        System.out.println("\n13. Logical Operators in Lambda Expressions:");
        java.util.function.Predicate<Integer> isPositiveAndEven = n -> n > 0 && n % 2 == 0;
        System.out.println("   Is 6 positive and even? " + isPositiveAndEven.test(6));
        System.out.println("   Is 5 positive and even? " + isPositiveAndEven.test(5));
    }

    private static boolean isPositive(int n) {
        return n > 0;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}