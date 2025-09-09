public class UnitConverterYardsFeetInches {

    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {
        double yards = 5, feet = 15, meters = 2, inches = 10;

        System.out.println(yards + " Yards = " + convertYardsToFeet(yards) + " Feet");
        System.out.println(feet + " Feet = " + convertFeetToYards(feet) + " Yards");
        System.out.println(meters + " Meters = " + convertMetersToInches(meters) + " Inches");
        System.out.println(inches + " Inches = " + convertInchesToMeters(inches) + " Meters");
        System.out.println(inches + " Inches = " + convertInchesToCm(inches) + " Cm");
    }
}
