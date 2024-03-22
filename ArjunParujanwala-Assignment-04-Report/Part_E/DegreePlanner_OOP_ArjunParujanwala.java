import java.util.Arrays;

public class DegreePlanner_OOP_ArjunParujanwala {
    public static void main(String[] args) {
        String[] semester01 = {"csc101", "csc102", "csc103", "csc104", "csc105", "csc106"};
        String[] semester02 = {"csc201", "csc202", "csc203", "csc204", "csc205", "csc206"};
        String[] semester03 = {"csc301", "csc302", "csc303", "csc304", "csc305", "csc306"};
        String[] semester04 = {"csc401", "csc402", "csc403", "csc404", "csc405", "csc406"};

        Semester[] semesters = new Semester[4];
        semesters[0] = new Semester(semester01);
        semesters[1] = new Semester(semester02);
        semesters[2] = new Semester(semester03);
        semesters[3] = new Semester(semester04);

        System.out.println("Printing data... from one 1D Semester[] array containing 4 items:");
        for (int i = 0; i < semesters.length; i++) {
            System.out.println(" - Semester #" + (i + 1) + " courses: " + semesters[i].getCoursesAsString());
        }
    }
}

class Semester {
    private final String[] courses;

    public Semester(String[] courses) {
        this.courses = courses;
    }

    public String getCoursesAsString() {
        return Arrays.toString(courses).replaceAll("[\\[\\]]", "");
    }
}



