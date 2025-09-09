import java.util.*;

public class BonusProgram {
    public static int[][] generateData(int n) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 10000 + (int)(Math.random()*90000);
            arr[i][1] = 1 + (int)(Math.random()*10);
        }
        return arr;
    }

    public static double[][] calculateNewSalary(int[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double bonus = data[i][1] > 5 ? 0.05*data[i][0] : 0.02*data[i][0];
            result[i][0] = data[i][0] + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void display(int[][] oldData, double[][] newData) {
        double oldSum=0,newSum=0,bonusSum=0;
        System.out.println("Salary\tYears\tNewSalary\tBonus");
        for (int i = 0; i < oldData.length; i++) {
            System.out.println(oldData[i][0]+"\t"+oldData[i][1]+"\t"+newData[i][0]+"\t"+newData[i][1]);
            oldSum+=oldData[i][0];
            newSum+=newData[i][0];
            bonusSum+=newData[i][1];
        }
        System.out.println("Total Old Salary: "+oldSum);
        System.out.println("Total New Salary: "+newSum);
        System.out.println("Total Bonus: "+bonusSum);
    }

    public static void main(String[] args) {
        int[][] data = generateData(10);
        double[][] updated = calculateNewSalary(data);
        display(data, updated);
    }
}
