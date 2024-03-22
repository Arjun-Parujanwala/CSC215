public class Array_2D_SingleDataType_ArjunParujanwala {
    public static void main(String[] args) {
        String[][] jaggedArray = jaggedAlphabet();
        String[][] standardAlphabet = {
                {"A", "B", "C", "D", "E", "F", "G"},
                {"", "", "", "H", "I", "J", "K"},
                {"", "", "L", "M", "N", "O", "P"},
                {"", "", "", "", "Q", "R", "S"},
                {"", "", "", "", "T", "U", "V"},
                {"", "", "", "", "", "W", "X"},
                {"", "", "", "", "", "Y", "Z"}
        };
        printAlphabets(standardAlphabet);
        printAlphabets(jaggedArray);
    }
    static public String[][] jaggedAlphabet(){
        String[][] raggedArray = new String[7][7];

        raggedArray[0][0] = "A";
        raggedArray[0][1] = "B";
        raggedArray[0][2] = "C";
        raggedArray[0][3] = "D";
        raggedArray[0][4] = "E";
        raggedArray[0][5] = "F";
        raggedArray[0][6] = "G";

        raggedArray[1][0] = "";
        raggedArray[1][1] = "";
        raggedArray[1][2] = "";
        raggedArray[1][3] = "H";
        raggedArray[1][4] = "I";
        raggedArray[1][5] = "J";
        raggedArray[1][6] = "K";

        raggedArray[2][0] = "";
        raggedArray[2][1] = "";
        raggedArray[2][2] = "L";
        raggedArray[2][3] = "M";
        raggedArray[2][4] = "N";
        raggedArray[2][5] = "O";
        raggedArray[2][6] = "P";

        raggedArray[3][0] = "";
        raggedArray[3][1] = "";
        raggedArray[3][2] = "";
        raggedArray[3][3] = "";
        raggedArray[3][4] = "Q";
        raggedArray[3][5] = "R";
        raggedArray[3][6] = "S";

        raggedArray[4][0] = "";
        raggedArray[4][1] = "";
        raggedArray[4][2] = "";
        raggedArray[4][3] = "";
        raggedArray[4][4] = "T";
        raggedArray[4][5] = "U";
        raggedArray[4][6] = "V";

        raggedArray[5][0] = "";
        raggedArray[5][1] = "";
        raggedArray[5][2] = "";
        raggedArray[5][3] = "";
        raggedArray[5][4] = "";
        raggedArray[5][5] = "W";
        raggedArray[5][6] = "X";

        raggedArray[6][0] = "";
        raggedArray[6][1] = "";
        raggedArray[6][2] = "";
        raggedArray[6][3] = "";
        raggedArray[6][4] = "";
        raggedArray[6][5] = "Y";
        raggedArray[6][6] = "Z";



        return raggedArray;
    }
    static void printAlphabets(String[][] alphabet) {
        System.out.println("Displaying contents in any 2D Arrays: ");
        for (String[] strings : alphabet) {
            for (String string : strings) {
                if(string.isEmpty()){
                    System.out.print(string + " ");
                }
                System.out.print(string + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


