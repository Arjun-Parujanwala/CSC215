public class BMI_CSC215_Metric_ArjunParujanwala {
    public static void main(String[] args) {
        String version = "metric";
        BMI_CSC215_Master_ArjunParujanwala.welcomeMessage(version);
        String name = BMI_CSC215_Master_ArjunParujanwala.getName();
        BMI_CSC215_Master_ArjunParujanwala.metricBMI(version, name);
        BMI_CSC215_Master_ArjunParujanwala.endingMessage(name);
    }
}