public class UnitConverterTempWeightVolume {

    // Temperature
    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9.0;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5.0) + 32;
    }

    // Weight
    public static double convertPoundsToKg(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKgToPounds(double kg) {
        return kg * 2.20462;
    }

    // Volume
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        double f = 100, c = 37, pounds = 50, kg = 20, gallons = 5, liters = 10;

        System.out.println(f + "°F = " + convertFahrenheitToCelsius(f) + "°C");
        System.out.println(c + "°C = " + convertCelsiusToFahrenheit(c) + "°F");

        System.out.println(pounds + " Pounds = " + convertPoundsToKg(pounds) + " Kg");
        System.out.println(kg + " Kg = " + convertKgToPounds(kg) + " Pounds");

        System.out.println(gallons + " Gallons = " + convertGallonsToLiters(gallons) + " Liters");
        System.out.println(liters + " Liters = " + convertLitersToGallons(liters) + " Gallons");
    }
}
