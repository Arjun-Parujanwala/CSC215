/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mycoursesthissemester;
import java.util.ArrayList;
/**
 *
 * @author arjunparujanwala
 */
public class MyCoursesThisSemester {
public static void main(String[] args) {
        // Create an ArrayList to store college classes
        ArrayList<String> collegeClasses = new ArrayList<>();

        // Add classes to the list
        collegeClasses.add("MATH 227");
        collegeClasses.add("CSC 216");
        collegeClasses.add("PHYS 220");
        collegeClasses.add("PHYS 222");
        collegeClasses.add("ENG 116");
        collegeClasses.add("RRS 110");

        // Print the list of college classes
        System.out.println("List of College Classes:");
        for (String className : collegeClasses) {
            System.out.println(className);
        }
    }
}
