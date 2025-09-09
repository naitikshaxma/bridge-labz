import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10], years = new double[10], bonus = new double[10], newSalary = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary and years of service for Employee " + (i+1) + ": ");
            double s = sc.nextDouble(), y = sc.nextDouble();
            if (s <= 0 || y < 0) { System.out.println("Invalid! Try again."); i--; continue; }
            salary[i] = s; years[i] = y;
        }

        for (int i = 0; i < 10; i++) {
            bonus[i] = (years[i] > 5) ? salary[i]*0.05 : salary[i]*0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i]; totalOld += salary[i]; totalNew += newSalary[i];
            System.out.println("Emp " + (i+1) + ": Old=" + salary[i] + " Bonus=" + bonus[i] + " New=" + newSalary[i]);
        }

        System.out.println("\nTotal Old=" + totalOld + " Total Bonus=" + totalBonus + " Total New=" + totalNew);
    }
}
