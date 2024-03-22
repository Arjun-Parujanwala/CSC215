import java.util.Scanner;
public class GardeningPlanner_ArjunParujanwala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] index = {" 0"," 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10","11"};
        //User Input
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CSC 215 Gardening Planner!");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("- Enter minimum temperature for plant: ");
        int mintemp = scanner.nextInt();
        System.out.print("- Enter maximum temperature for plant: ");
        int maxtemp = scanner.nextInt();
        System.out.print("- Enter minimum rainfall for plant: ");
        int minrain = scanner.nextInt();
        System.out.println("----------------------------------------------------------------------------------------- \n");
        //Print out Height Values and with Max Value with "MAX"
        int plantheight = 0;
        int[] Heightlist = new int[12];
        for(int j = 0; j < 12; j++){
            plantheight = getheight(getgrowth(mintemp,maxtemp,minrain, getavgTemp(j),getavgRain(j)), plantheight);
            Heightlist[j] = plantheight;
        }
        int max = Heightlist[0];
        for(int t = 1; t < Heightlist.length; t++){
            if(Heightlist[t] > max){
                max = Heightlist[t];
            }
        }
        String[] maxlist = new String[12];
        for(int l = 0; l < Heightlist.length; l++){
            if(Heightlist[l] == max){
                maxlist[l] = "\u001B[43;30mMAX\u001B[0m";
            }
            else {
                maxlist[l] = " ";
            }
        }
        //Print out Table
        System.out.print("-------------- -------------- -------------- -------------- -------------- -------------- \n");
        System.out.printf("%-14s %-14s %-14s %-14s %-14s %-14s", "INDEX", "MONTH", "TEMPERATURE", "RAINFALL","PLANT GROWTH", "PLANT HEIGHT");
        for(int i = 0; i < 12; i++){
            System.out.println();
            System.out.printf("%-14s %-14s %-14s %-14s %-14s %-4s %1s", index[i], month[i], getavgTemp(i), getavgRain(i),
                    getNumberWithPlusSign(getgrowth(mintemp,maxtemp,minrain, getavgTemp(i),getavgRain(i))), Heightlist[i], maxlist[i]);
        }
        System.out.println();
        System.out.println("-------------- -------------- -------------- -------------- -------------- -------------- ");
    }
    //Get Growth
    public static int getgrowth(int mintemp, int maxtemp, int minrain, int avgtemp, int avgrain){
        int growth = 0;
        if(avgtemp < mintemp || avgtemp > maxtemp){
            growth -= 1;
            return growth;
        }
        growth = avgrain - minrain;
        return growth;
    }
    //Get Height
    public static int getheight(int growth, int height){
        height +=growth;
        if(height < 0){
            height = 0;
        }
        return height;
    }
    //Get Average Temperature
    public static int getavgTemp(int i){
        int[] avgTempData = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
        return avgTempData[i];
    }
    //Get Average Rain
    public static int getavgRain(int i){
        int[] avgRainData = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
        return avgRainData[i];
    }
    //Return Growth Values that are positive or 0 with plus sign
    public static String getNumberWithPlusSign(int num){
        if (num >= 0) {
            return "+"+num;
        } else {
            return ""+num;
        }
    }
}
