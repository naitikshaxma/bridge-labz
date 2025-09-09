public class MatrixAdvanced {
    public static int[][] transpose(int[][] m){
        int[][] t=new int[m[0].length][m.length];
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m[0].length;j++)
                t[j][i]=m[i][j];
        return t;
    }

    public static int det2x2(int[][] m){
        return m[0][0]*m[1][1]-m[0][1]*m[1][0];
    }

    public static int det3x3(int[][] m){
        return m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(int[][] m){
        int det=det2x2(m);
        double[][] inv=new double[2][2];
        inv[0][0]= m[1][1]/(double)det;
        inv[0][1]=-m[0][1]/(double)det;
        inv[1][0]=-m[1][0]/(double)det;
        inv[1][1]= m[0][0]/(double)det;
        return inv;
    }

    public static void print(int[][] m){
        for(int[] row:m){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
