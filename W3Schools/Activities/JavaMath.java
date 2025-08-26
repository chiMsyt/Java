public class JavaMath {
    
    // the Java Math class has many methods that allows you to perform mathermatical tasks on numbers.

    public static void main(String[] args) {
        
        /* Math.max(x,y)
         * The Math.max(x,y) method can be used to find the highest value of x and y. */
        System.out.println(Math.max(5, 10));;

        /* Math.min(x,y)
         * The Math.min(x,y) method can be used to find the lowest value of x and y */
        System.out.println(Math.min(5, 10));

        /* Math.sqrt(x) 
         * The Math.sqrt(x) method returns the square root of x: */
        System.out.println(Math.sqrt(64));

        /* Math.abs(x)
         * The Math.abs(x) method returns the absolute (postive) value of x: */
        System.out.println(Math.abs(-4.7));

        /* Random Numbers
         * Math.random() returns a random number between 0.0 (inclusive), and 1.0 (exclusive): */
        System.out.println(Math.random());
        
        /* To get more control over the random numbers,
         * multiply it with desired number + 1 */
        System.out.println(Math.random() * 101); // 0 to 100

    }
}
