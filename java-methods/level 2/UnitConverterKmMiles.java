public class UnitConverterKmMiles {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        return miles / 0.621371;
    }

    public static void main(String[] args) {
        double km = 10;
        double miles = 6.21;

        System.out.println(km + " Km = " + convertKmToMiles(km) + " Miles");
        System.out.println(miles + " Miles = " + convertMilesToKm(miles) + " Km");
    }
}
