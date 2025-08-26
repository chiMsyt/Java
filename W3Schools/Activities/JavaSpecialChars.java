public class JavaSpecialChars {
    
    /* Strings - Special Characters
     * Strings must be written within quotes, if using another word that needs quotation,
     * it will generate an error. */

     public static void main(String[] args) {
        
        /* The solution to avoid this problem, is to use the backslash escape character
         * (\) turns special characters into string characters. */
        String txt = "We are the so-called \"Vikings\" from the north.";
        System.out.println(txt);

        // The sequence \' inserts a single quote in a string:
        String txt2 = "It\'s alright.";
        System.out.println(txt2);

        // The sequence \\ inserts a single backslash in a string:
        String txt3 = "The character \\ is called backslash";
        System.out.println(txt3);
     }
}
