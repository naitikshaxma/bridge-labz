import java.util.*;

public class MatrixOps {
    public static int[][] randomMatrix(int r,int c){
        int[][] m=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*10);
        return m;
    }

    public static int[][] add(int[][] a,int[][] b){
        int[][] res=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                res[i][j]=a[i][j]+b[i][j];
        return res;
    }

    public static int[][] subtract(int[][] a,int[][] b){
        int[][] res=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                res[i][j]=a[i][j]-b[i][j];
        return res;
    }

    public static int[][] multiply(int[][] a,int[][] b){
        int[][] res=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<b[0].length;j++)
                for(int k=0;k<a[0].length;k++)
                    res[i][j]+=a[i][k]*b[k][j];
        return res;
    }

    public static void print(int[][] m){
        for(int[] row:m){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
    }
