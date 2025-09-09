import java.util.*;

public class StudentScorecard {
    public static int[][] generateScores(int n) {
        int[][] scores=new int[n][3];
        for(int i=0;i<n;i++)
            for(int j=0;j<3;j++)
                scores[i][j]=10+(int)(Math.random()*90);
        return scores;
    }

    public static double[][] calculate(int[][] scores) {
        double[][] result=new double[scores.length][3];
        for(int i=0;i<scores.length;i++) {
            int total=scores[i][0]+scores[i][1]+scores[i][2];
            double avg=total/3.0;
            double perc=(total/300.0)*100;
            result[i][0]=total;
            result[i][1]=Math.round(avg*100.0)/100.0;
            result[i][2]=Math.round(perc*100.0)/100.0;
        }
        return result;
    }

    public static void display(int[][] scores,double[][] calc) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPerc");
        for(int i=0;i<scores.length;i++)
            System.out.println(scores[i][0]+"\t"+scores[i][1]+"\t"+scores[i][2]+"\t"+calc[i][0]+"\t"+calc[i][1]+"\t"+calc[i][2]);
    }
}