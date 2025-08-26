public class ArraySeatwork {
    public static void main(String[] args) {
        // 2. Create an array of type String called cars
        String[] cars = {"Volvo", "BMW", "Ford"};

        // 3. Print the second item in the cars array
        System.out.println("Second item: " + cars[1]);

        // 4. Change the value from "Volvo" to "Opel"
        cars[0] = "Opel";
        System.out.println("After change, first item: " + cars[0]);

        // 5. Find out how many elements the cars array has
        System.out.println("Number of elements: " + cars.length);
    }
}
