import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Prompt the user to either choose English or Metric
//Prompt the user to enter the user's name
//Prompt the user to enter height
//Prompt the user to enter weight
//Calculate the BMI of the user and display a summary report
//Prompt our user to enter a low eight and high weight in kilograms
//Generate and display a table of BMI information for the entered weight range
public class BMI_CSC215_Master_ArjunParujanwala {
    public static void main(String[] args) {
        String version = askForVersion();
        welcomeMessage(version);
        String name = getName();

        if (version.equals("english")) {
            englishBMI(version, name);
        } else if (version.equals("metric")) {
            metricBMI(version, name);
        }
        endingMessage(name);
    }

    public static String askForVersion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                My CSC 215 BMI Calculator Projects:\s
                   1. BMI. English
                   2. BMI, Metric
                                
                [ USER MANUAL ] Enter an exclamation mark ! to end.
                Please enter the version you want to try: \s""");

        String choice = scanner.nextLine().toLowerCase();
        if(Objects.equals(choice, "!")){
            System.exit(0);
        }
        char firstLetter = choice.charAt(0);

        if (choice.contains("english") || firstLetter == 'e') {
            return "english";
        } else if (choice.contains("metric") || firstLetter == 'm') {
            return "metric";
        } else {
            System.out.println("Invalid choice. Please enter 'English' or 'Metric'.");
            return askForVersion(); // Prompt the user again for a valid choice
        }
    }

    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();
        if (Objects.equals(name, "!")){
            System.exit(0);
        }
        return name;
    }

    public static double englishBMI(String version, String name) {
        Scanner scanner = new Scanner(System.in);
        double height = getHeight(version);
        double weight = getWeight(version);
        double initialWeight = weight;
        double bmi = getBMI(version, height, weight);
        double initialBMI = bmi;
        summaryReport(bmi, name);
        System.out.print("\nEnter a LOW weight in pounds for " + name + ": ");
        double lowWeight = scanner.nextDouble();
        System.out.print("Enter a HIGH weight in pounds for " + name + ": ");
        double highWeight = scanner.nextDouble();

        if (lowWeight > highWeight) {
            System.out.print("Error: Low weight should be less than or equal to high weight.");
        }
        generateAndDisplayBMITable(version, lowWeight, highWeight, height, initialWeight, initialBMI);
        return height;
    }

    public static double metricBMI(String version, String name) {
        Scanner scanner = new Scanner(System.in);
        double height = getHeight(version);
        double weight = getWeight(version);
        double initialWeight = weight;
        double bmi = getBMI(version, height, weight);
        double initialBMI = bmi;
        summaryReport(bmi, name);
        System.out.print("\nEnter a LOW weight in kilograms for: " + name + ":");
        double lowWeight = scanner.nextDouble();
        System.out.print("Enter a HIGH weight in kilograms for: " + name + ":");
        double highWeight = scanner.nextDouble();

        if (lowWeight > highWeight) {
            System.out.print("Error: Low weight should be less than or equal to high weight.");
        }
        generateAndDisplayBMITable(version, lowWeight, highWeight, height, initialWeight, initialBMI);

        return height;
    }

    public static String welcomeMessage(String version) {
        String message = null;
        if (version.equals("english")) {
            message = "English";
        } else if (version.equals("metric")) {
            message = "Metric";
        }
        System.out.println("--------------------------------------------------------------------------------------------------\n" +
                "-- Welcome to: \n" +
                "--            BODY MASS INDEX (BMI) Computation, CSC 215, " + message + " Version\n" +
                "--                                                                   by Arjun Parujanwala\n" +
                "--------------------------------------------------------------------------------------------------\n");
        return message;
    }

    public static double getHeight(String version) {
        if (version.equals("english")) {
            System.out.print("Please enter your height in inches: ");
            return (new java.util.Scanner(System.in).nextDouble());
        } else if (version.equals("metric")) {
            System.out.print("Please enter your height in centimeters: ");
            return (new java.util.Scanner(System.in).nextDouble());
        }
        return 0;
    }

    public static double getWeight(String version) {
        if (version.equals("english")) {
            System.out.print("Please enter your weight in pounds: ");
            return (new java.util.Scanner(System.in).nextDouble());
        } else if (version.equals("metric")) {
            System.out.print("Please enter your weight in kilograms: ");
            return (new java.util.Scanner(System.in).nextDouble());
        }
        return 0;
    }

    public static double getBMI(String version, double height, double weight) {
        double bmi = 0;
        if (version.equals("english")) {
            bmi = (weight / (height * height)) * 703;
        } else if (version.equals("metric")) {
            bmi = weight / ((height / 100) * (height / 100));
        }
        return roundToHundredths(bmi);
    }

    public static double roundToHundredths(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static String summaryReport(double bmi, String name) {
        String time = getCurrentDateTime();
        System.out.println("\n-- SUMMARY REPORT for " + name.toUpperCase());
        System.out.printf("-- Date and Time:     %s%n", time);
        String status = weightStatus(bmi);
        System.out.printf("-- BMI:               %.2f%n", bmi);
        System.out.printf("-- Weight Status:     %s%n", status);

        return status;
    }

    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss a");

        return now.format(formatter);
    }

    public static String weightStatus(double bmi) {
        if (bmi >= 30) {
            return "Obesity";
        } else if (bmi <= 29.9 && bmi >= 25.0) {
            return "Overweight";
        } else if (bmi <= 24.9 && bmi >= 18.5) {
            return "Healthy";
        } else if (bmi < 18.5) {
            return "Underweight";
        } else {
            return "Who knows.";
        }
    }

    public static void generateAndDisplayBMITable(String version, double lowWeight, double highWeight, double height, double initialWeight, double initialBMI) {
        System.out.println("\n---------------------------------------------------------");
        System.out.println("|   WEIGHT   |    BMI      |   WEIGHT STATUS            |");
        System.out.println("---------------------------------------------------------");

        double weight = lowWeight;
        boolean initialBMIPrinted = false;
        if (version.equals("english")) {
            for (weight = lowWeight; weight <= highWeight; weight += 5.5) {
                double bmi = getBMI(version, height, weight);
                String status = weightStatus(bmi);
                if (!initialBMIPrinted && initialBMI < bmi) {
                    String format = "|%11.2f |%12.2f |%14s        (this)|%n";
                    System.out.printf(format, initialWeight, initialBMI, status);
                    initialBMIPrinted = true;
                }
                printTableRow(weight, bmi, status, lowWeight, highWeight);
            }
        } else if (version.equals("metric")) {
            for (weight = lowWeight; weight <= highWeight; weight += 2.5) {
                double bmi = getBMI(version, height, weight);
                String status = weightStatus(bmi);
                if (!initialBMIPrinted && initialBMI < bmi) {
                    String format = "|%11.2f |%12.2f |%14s (this)|%n";
                    System.out.printf(format, initialWeight, initialBMI, status);
                    initialBMIPrinted = true;
                }
                printTableRow(weight, bmi, status, lowWeight, highWeight);
            }
        }
        if(weight > highWeight){
            String highlightHigh = "         \033[1;43mHIGH\033[0m";
            String format = "|%11.2f |%12.2f |%14s %-13s|%n";
            double bmi = getBMI(version, height, weight);
            String status = weightStatus(bmi);
            System.out.printf(format, weight, bmi, status, highlightHigh);
        }
        System.out.println("---------------------------------------------------------");
    }

    public static void printTableRow(double weight, double bmi, String status, double lowWeight, double highWeight) {
        String highlightLow = (weight == lowWeight) ? "          \033[1;43mLOW\033[0m" : "";
        String highlightHigh = (weight == highWeight) ? "         \033[1;43mHIGH\033[0m" : "";

        String format = "|%11.2f |%12.2f |%14s %-13s|%n";

        // Highlight "HIGH" for the last row
        if (weight == highWeight) {
            System.out.printf(format, weight, bmi, status, highlightHigh);
        } else {
            System.out.printf(format, weight, bmi, status, highlightLow);
        }
    }

    public static void endingMessage(String name) {
        System.out.println("\n\nThe SFSU Mashouf Wellness Center is at 755 Font Blvd.\n\n" +
                "---------------------------------------------------------------------------------\n" +
                "-- Thank you for using my program, " + name + "!\n" +
                "-- Bye.\n" +
                "----------------------------------------------------------------------------------");
    }
}