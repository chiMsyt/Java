public class Main { 
    /* Every line of code that runs in Java must be inside a class. 
    * The class name should always start with an uppercase first letter. "Main"
    * Java is case-sensitive: "MyClass" and "myclass" have different meanings.
    * The name of the java file must match the class name. class name = file name */
    public static void main(String[] args) {
        /* Any code inside the main() method will be executed
         * Every program must contain the main() method */
        System.out.println("Hello World");
        // You can add as many printLn() methods as you want - it will add a new line for each method.
        System.out.println("I am learning Java.");
        System.out.println("It's awesome!");
        // Text must be wrapped inside double quotation marks (""), an error occurs if not.
        System.out.print("This is print, ");
        System.out.print("this will print on the same line");
        // print will not break texts, it will print it on the same line.
        System.out.println(3);
        System.out.println(358);
        System.out.println(50000);
        // If printing numbers, no need to wrap it in quotation marks.
        System.out.println(3 + 3);
        System.out.println(2 * 5);
        // We can also print mathematical equations - output will then be the answer
    }
}
/* The curly braces {} marks the beginning and end of a block of code.
 * System is a built-in Java class that contains useful members such as out - output
 * printLn() method - print line, is used to print a value to the screen (or a file).
 * Each code statement must end with a semicolon (;). */