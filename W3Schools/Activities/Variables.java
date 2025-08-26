public class Variables {
    /* In Java, there are different types of variables
     * String - stores text - "Hello" - surrounded by ""
     * int - stores integers (whole numbers), w/ no decimals
     * float - stores floating point numbers, with decimals
     * char - stores single characters such as 'a' or 'B'
     * boolean - stores values with two states: true or false */
    public static void main(String[] args) {
        String name = "Timothy";
        System.out.println(name);
        // prints the variable name
        int myNum = 22;
        System.out.println(myNum);
        /* prints the variable myNum
         * Use the keyword final to make a variable a constant */
        final int myNum1 = 23;
        System.out.println(myNum1);
        int myNum2 = 2002;
        float myFloatNum = 5.99f;
        char myLetter = 'M';
        boolean myBool = true;
        String myText = "honey";
        System.out.println("Heyy " + myText);
        // Use the + symbol to add a variable to another variable
        int S = 5, T = 6, C = 50;
        System.out.println(S + T + C);
        // Instead of assigning variables line by line, we can do it in one line with this
        int x, y, o;
        x = y = o = 69;
        System.out.println(x + y + o);
        // We can also assign the same value to multiple variables in one line
    }
}