public class JavaStrings {
    
    /* String Length
     * A String in Java is actually an object.
     * Contains methods that can perform certain operations on strings
     * For example, the length of a string can be found with the length() method. */

     public static void main(String[] args) {
        
        String txt = "ABCDEFGJHIJKLMNOPQRSTUVWXYZ";
        System.out.println("The length of the txt string is: " + txt.length());

        // There are many string methods available, toUpperCase() and toLowerCase():
        String txt2 = "Hello World";
        System.out.println(txt2.toUpperCase()); // Outputs "HELLO WORLD"
        System.out.println(txt2.toLowerCase()); // Outputs "hello world"

        /* Finding a Character in a String
         * The indexOf() method returns the index (the position) of the first occurence of a specified text in a string (including whitespace): */
        String txt3 = "Please locate where 'locate' occurs!";
        System.out.println(txt3.indexOf("locate")); // Outputs 7
     }
}
