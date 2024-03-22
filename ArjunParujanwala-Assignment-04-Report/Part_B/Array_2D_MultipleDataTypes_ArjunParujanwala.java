import java.util.Scanner;
public class Array_2D_MultipleDataTypes_ArjunParujanwala {
    public static void main(String[] args) {
        int[] numbers = getUserInputInt();
        char[] characters = getUserInputChar();
        String[] strings = getUserInputString();
        Object[] objects = createMixedArray();
        dataTable(numbers, characters, strings, objects);

        Object[][] dataTable = (Object[][]) dataTable(numbers, characters, strings, objects);
        System.out.println("\nYour 2D array of multiple data types: ");
        printDataTypes(dataTable);
        printDataTable(dataTable);
    }
    public static int[] getUserInputInt(){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        System.out.print("Row 1 |  Please enter 3 Integers:     ");
        for(int i = 0; i < 3; i++){
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static char[] getUserInputChar(){
        Scanner scanner = new Scanner(System.in);
        char[] characters = new char[3];
        System.out.print("Row 2 |  Please enter 3 Characters:   ");
        for(int i = 0; i < 3; i++){
            characters[i] = scanner.next().charAt(0);
        }
        return characters;
    }

    public static String[] getUserInputString(){
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];
        System.out.print("Row 3 |  Please enter 3 Strings:      ");
        for(int i = 0; i < 3; i++){
            strings[i] = scanner.next();
        }
        return strings;
    }

    public static Object[] createMixedArray() {
        Scanner scanner = new Scanner(System.in);
        Object[] mixedArray = new Object[5];
        System.out.print("Row 4 | 1 Int, 1 Char, 1 String:      ");
        mixedArray[0] = scanner.nextInt();
        mixedArray[1] = scanner.next().charAt(0);
        mixedArray[2] = scanner.next();
        return mixedArray;
    }

    public static Object[] dataTable(int[] numbers, char[] characters, String[] strings, Object[] objects){
        Object[][] inputDatabase = new Object[4][3];
        inputDatabase[0][0] = numbers[0];
        inputDatabase[0][1] = numbers[1];
        inputDatabase[0][2] = numbers[2];

        inputDatabase[1][0] = characters[0];
        inputDatabase[1][1] = characters[1];
        inputDatabase[1][2] = characters[2];

        inputDatabase[2][0] = strings[0];
        inputDatabase[2][1] = strings[1];
        inputDatabase[2][2] = strings[2];

        inputDatabase[3][0] = objects[0];
        inputDatabase[3][1] = objects[1];
        inputDatabase[3][2] = objects[2];
        return inputDatabase;
    }

    public static void printDataTable(Object[][] dataTable) {
        System.out.println("- Data Value View:");
        for (Object[] row : dataTable) {
            System.out.print("               ");
            for (Object element : row) {
                if (element instanceof Integer) {
                    System.out.printf("%-35d", (Integer) element);
                } else if (element instanceof Character) {
                    System.out.printf("%-35c", (Character) element);
                } else if (element instanceof String) {
                    System.out.printf("%-35s", (String) element);
                } else {
                    System.out.printf("%-35s", "Unknown");
                }
            }
            System.out.println(); // Move to the next row
        }
    }



    public static void printDataTypes(Object[][] dataTable) {
        System.out.println("\n- Data Type View:");

        // Iterate through rows
        for (int i = 0; i < 4; i++) {
            System.out.print("               ");
            // Iterate through columns
            for (int j = 0; j < 3; j++) {
                // Print the data type
                printDataType(dataTable[i][j]);
            }
            System.out.println(); // Move to the next row
        }
    }

    public static void printDataType(Object element) {
        System.out.printf("%-35s", element.getClass().getSimpleName());
    }

}

