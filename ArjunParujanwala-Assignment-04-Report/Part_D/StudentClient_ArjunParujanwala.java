/**
 * Please implement class StudentClient by adding code to it.
 * Please DO NOT change the provided code. ONLY add more code.
 *
 * Class:       StudentClient
 * File Name:   StudentClient.java
 *
 * @author Duc Ta
 */
package asmt05;
import java.util.Scanner;

public class StudentClient_ArjunParujanwala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double gpa;
        String name1;
        String name2;
        String name3;

        //User Input
        System.out.println("[+] Creating 3 students...");

        // Student 1
        System.out.print(" - Enter a name for student #1: ");
        name1 = scanner.nextLine();
        System.out.print(" - Enter a GPA for student #1:  ");
        gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        Student student1 = new Student(name1, gpa);
        System.out.println();

        // Student 2
        System.out.print(" - Enter a name for student #2: ");
        name2 = scanner.nextLine();
        System.out.print(" - Enter a GPA for student #2:  ");
        gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        Student student2 = new Student(name2, gpa);
        System.out.println();

        // Student 3
        System.out.print(" - Enter a name for student #3: ");
        name3 = scanner.nextLine();
        System.out.print(" - Enter a GPA for student #3:  ");
        gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        Student student3 = new Student(name3, gpa);
        System.out.println();

        // Display
        System.out.println("[+] The 3 students created: ");
        System.out.println(student1);
        System.out.println("'this' student---\nname: " + student2.getName() + "\ngpa:  " + student2.getGpa());
        System.out.println(student3);

        // Update
        boolean validName = false;
        while (!validName) {
            System.out.print("\n[-] Enter a student's full name to update the student: ");
            String name = scanner.nextLine();

            if (name1.equalsIgnoreCase(name)) {
                System.out.print("[-] Enter new student name: ");
                student1.setName(scanner.nextLine());
                System.out.print("[-] Enter new student GPA:  ");
                student1.setGpa(scanner.nextDouble());
                scanner.nextLine(); // Consume the newline character
                validName = true;
            } else if (name2.equalsIgnoreCase(name)) {
                System.out.print("[-] Enter new student name: ");
                student2.setName(scanner.nextLine());
                System.out.print("[-] Enter new student GPA:  ");
                student2.setGpa(scanner.nextDouble());
                scanner.nextLine(); // Consume the newline character
                validName = true;
            } else if (name3.equalsIgnoreCase(name)) {
                System.out.print("[-] Enter new student name: ");
                student3.setName(scanner.nextLine());
                System.out.print("[-] Enter new student GPA:  ");
                student3.setGpa(scanner.nextDouble());
                scanner.nextLine(); // Consume the newline character
                validName = true;
            } else {
                System.out.println("[-] The student with the name '" + name + "' was not found. Please enter a valid name.");
            }
        }

        // Updated Display
        System.out.println("\n[+] The 3 students updated: ");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        scanner.close();
    }

}
