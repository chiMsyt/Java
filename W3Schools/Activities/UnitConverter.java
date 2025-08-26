import java.util.Scanner;

public class UnitConverter {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\nUnit Converter Menu:");
        System.out.println("1. Length Conversion (meters to kilometers, miles, feet to centimeters)");
        System.out.println("2. Weight Conversion (grams to kilograms, pounds)");
        System.out.println("3. Temperature Conversion (Celsius to Fahrenheit, Kelvin)");
        System.out.println("4. Exit");
    }

    public static void lengthConversion() {
        System.out.println("\nLength Conversion Options:");
        System.out.println("1. Meters to Kilometers and Miles");
        System.out.println("2. Feet and Inches to Centimeters");
        System.out.print("Choose an option (1-2): ");
        String choice = scanner.next();

        if (choice.equals("1")) {
            System.out.print("Enter the length in meters: ");
            double meters = scanner.nextDouble();
            double kilometers = meters / 1000;
            double miles = meters / 1609.34;
            System.out.printf("%.2f meters is %.3f kilometers or %.3f miles.\n", meters, kilometers, miles);
        } else if (choice.equals("2")) {
            System.out.print("Enter the length in feet and inches (e.g., 5 7 for 5'7\"): ");
            try {
                int feet = scanner.nextInt();
                int inches = scanner.nextInt();
                int totalInches = (feet * 12) + inches;
                double centimeters = totalInches * 2.54;
                System.out.printf("%d feet %d inches is %.2f centimeters.\n", feet, inches, centimeters);
            } catch (Exception e) {
                System.out.println("Invalid format. Please enter two numbers separated by space (e.g., 5 7 for 5'7\").");
                scanner.nextLine(); // Clear the input buffer
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    public static void weightConversion() {
        System.out.print("Enter the weight in grams: ");
        double grams = scanner.nextDouble();
        double kilograms = grams / 1000;
        double pounds = grams / 453.592;
        System.out.printf("%.2f grams is %.3f kilograms or %.3f pounds.\n", grams, kilograms, pounds);
    }

    public static void temperatureConversion() {
        System.out.print("Enter the temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;
        System.out.printf("%.2f°C is %.2f°F or %.2fK.\n", celsius, fahrenheit, kelvin);
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Choose an option (1-4): ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    lengthConversion();
                    break;
                case "2":
                    weightConversion();
                    break;
                case "3":
                    temperatureConversion();
                    break;
                case "4":
                    System.out.println("Exiting the unit converter. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
            }
        }
    }
}
