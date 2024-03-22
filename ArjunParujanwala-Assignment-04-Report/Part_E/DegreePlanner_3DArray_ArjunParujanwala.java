public class DegreePlanner_3DArray_ArjunParujanwala {
    public static void main(String[] args) {
        String[] semester01 = {"csc101", "csc102", "csc103", "csc104", "csc105", "csc106"};
        String[] semester02 = {"csc201", "csc202", "csc203", "csc204", "csc205", "csc206"};
        String[] semester03 = {"csc301", "csc302", "csc303", "csc304", "csc305", "csc306"};
        String[] semester04 = {"csc401", "csc402", "csc403", "csc404", "csc405", "csc406"};

        String[][][] semesters = loadSemesterData(semester01, semester02, semester03, semester04);
        printSemesterData(semesters);
    }
    public static String[][][] loadSemesterData(String[] semester01, String[] semester02, String[] semester03, String[] semester04){
        String[][][] semesters = new String[4][3][2];
        semesters[0][0][0] = semester01[0];
        semesters[0][0][1] = semester01[1];
        semesters[0][1][0] = semester01[2];
        semesters[0][1][1] = semester01[3];
        semesters[0][2][0] = semester01[4];
        semesters[0][2][1] = semester01[5];

        semesters[1][0][0] = semester02[0];
        semesters[1][0][1] = semester02[1];
        semesters[1][1][0] = semester02[2];
        semesters[1][1][1] = semester02[3];
        semesters[1][2][0] = semester02[4];
        semesters[1][2][1] = semester02[5];

        semesters[2][0][0] = semester03[0];
        semesters[2][0][1] = semester03[1];
        semesters[2][1][0] = semester03[2];
        semesters[2][1][1] = semester03[3];
        semesters[2][2][0] = semester03[4];
        semesters[2][2][1] = semester03[5];

        semesters[3][0][0] = semester04[0];
        semesters[3][0][1] = semester04[1];
        semesters[3][1][0] = semester04[2];
        semesters[3][1][1] = semester04[3];
        semesters[3][2][0] = semester04[4];
        semesters[3][2][1] = semester04[5];

        return semesters;
    }

    public static void printSemesterData(String[][][] semesters) {
        System.out.println("Printing data... from one 3D String[4][3][2] array containing 24 items:");
        for (int semesterIndex = 0; semesterIndex < semesters.length; semesterIndex++) {
            System.out.print("Semester #" + (semesterIndex + 1) + ": ");
            for (int i = 0; i < semesters[semesterIndex].length; i++) {
                for (int j = 0; j < semesters[semesterIndex][i].length; j++) {
                    System.out.print(semesters[semesterIndex][i][j]);
                    if (!(i == semesters[semesterIndex].length - 1 && j == semesters[semesterIndex][i].length - 1)) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println();
        }
    }
}
