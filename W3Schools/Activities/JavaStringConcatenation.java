public class JavaStringConcatenation {
    

    /* String Concatenation
     * The + operator can be used between strings to combine them. */

     public static void main(String[] args) {
        
        String firstName = "Marsella";
        String lastName = "Sy";
        System.out.println(firstName + " " + lastName); // Outputs Marsella Sy
        System.out.println(firstName.concat(lastName)); // Outputs MarsellaSy
     }
}
