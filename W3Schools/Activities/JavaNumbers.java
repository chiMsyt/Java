public class JavaNumbers {
    
    /* Primitive number types are divided into two groups:
     * Integer types stores whole numbers (+ or -), without decimals.
     * byte, short, int, and long - which type to be used will depend on numeric value
     * Floating point types represents numbers with a fractional part, containing one or more decimals
     * float and double 
     * Even though there are many numberic types in Java, the most used is int and double. */

     public static void main(String[] args) {
        
        // Byte data type can store whole numbers, can be used instead of int (if value is between -128 and 127)
        byte myNum = 100;
        System.out.println(myNum);
        // Short data type can store whole numbers from -32768 to 32767
        short myNum2 = 5000;
        System.out.println(myNum2);
        /* Int data type can store whole numbers from -2147483648 to 2147483647. 
         * It is the preferred data type when we create variables with a numeric value. */
        int myNum3 = 1000000;
        System.out.println(myNum3);
        /* Long data type can store whole numbers from -9223372036854775808 to 9223372036854775807.
         * This is used when int is not large enough to store the value.
         * Note that you should end the value with an "L": */
        long myNum4 = 15000000000L;
        System.out.println(myNum4);
        /* You should use a floating point type whenever you need a number with a decimal, such as 9.99 or 3.14515.
         * The float and double data types can store fractional numbers.
         * Note that you should end the value with an "f" for floats and "d" for doubles: 
         * Use float or double?
         * The precision of a floating point value indicates how many digits the value can have after the decimal point.
         * The precision of float is only six or seven decimal digits
         * Double variables have a precision of about 15 digits. Therefore it is safer to use double for most calculations. */
        float myNum5 = 5.75f;
        System.out.println(myNum5);
        double myNum6 = 19.99d;
        System.out.println(myNum6);
        /* Scientific Numbers
         * A floating point number can also be a scientific number with an "e" to indicate the power of 10: */
        float f1 = 35e3f;
        double d1 = 12E4d;
        System.out.println(f1);
        System.out.println(d1);
     }
}
