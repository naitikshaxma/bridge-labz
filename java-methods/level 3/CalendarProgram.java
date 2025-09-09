import java.util.*;

public class CalendarProgram {
    static String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeap(int year) {
        return (year%4==0 && year%100!=0) || (year%400==0);
    }

    public static int getFirstDay(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31*m)/12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int numDays = days[month-1];
        if (month == 2 && isLeap(year)) numDays = 29;
        int startDay = getFirstDay(month, year);

        System.out.println("Calendar for " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDay; i++) System.out.print("    ");
        for (int d = 1; d <= numDays; d++) {
            System.out.printf("%3d ", d);
            if ((d + startDay) % 7 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int year = sc.nextInt();
        displayCalendar(month, year);
    }
}
