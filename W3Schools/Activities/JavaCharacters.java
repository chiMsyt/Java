public class JavaCharacters {
    
    /* Characters
     * The char data type is used to store a single character. 
     * The character must be surrounded by single quotes, like 'A' or 'c': */

     public static void main(String[] args) {
        
        char myGrade = 'A';
        System.out.println(myGrade);

        // Alternatively, we can use ASCII values to display certain characters:
        char myVar1 = 77, myVar2 = 97, myVar3 = 114, myVar4 = 115, myVar5 = 101, myVar6 = 108, myVar7 = 33, myVar8 = 94, myVar9 = 45;
        System.out.printf("%c%c%c%c%c%c%c%c%c %c%c%c", myVar1, myVar2, myVar3, myVar4, myVar5, myVar6, myVar6, myVar2, myVar7, myVar8, myVar9, myVar8);
     }
}
