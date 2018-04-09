public class PascalTriangle {

    public static void main (String[] args) {

        for (int n = 0; n < 10; n++){
            int Cnk = 1;
            System.out.print(Cnk);
            for (int k = 1; k <=n; k++){
                Cnk *= (n-k+1);
                Cnk /= k;
                System.out.print(" "); System.out.print(Cnk);
            }
            System.out.println();
        }

        System.out.println();
        int  n=7;
        int  m=7;

        //Диагональный обход
        int counter3 = 1, counterOfCycle = 0;
        boolean flag = false;
        int[][] matrix4 = new int[n][m];
        int x = 0, y = 0;
        matrix4[y][x] = counter3++;
        while (!flag)
        {
            if (counterOfCycle++ % 2 == 0)
            {

                if (y <= n-2 ) {
                    matrix4[++y][x] = counter3++;
                    while ((y > 0) && (x < m-1)) {
                        matrix4[--y][++x] = counter3++;
                    }
                }

                else if (x <= m-2 ) {
                    matrix4[y][++x] = counter3++;
                    while ((y > 0) && (x < m-1)) {
                        matrix4[--y][++x] = counter3++;
                    }
                }

                else flag = true;


            }
            else {

                if (x <= m-2 ) {
                    matrix4[y][++x] = counter3++;
                    while ((y < n - 1) && (x > 0)) {
                        matrix4[++y][--x] = counter3++;
                    }
                }

                else if (y <= n-2 ) {
                    matrix4[++y][x] = counter3++;
                    while ((y < n - 1) && (x > 0)) {
                        matrix4[++y][--x] = counter3++;
                    }
                }

                else flag = true;

            }
        }
        Output(matrix4, n, m);

        System.out.println();

        //По часовой стрелке
        int[][] matrix = new int[n][m];
        int i=1,j,k,p=n/2;

        for(k=1;k<=p + 1;k++)
        {
            if (k > m)
            break;

            for (j=k-1;j<m-k+1;j++)
                if ( matrix[k-1][j] == 0) matrix[k-1][j]=i++;/*Определение значений верхнего гор столбца*/
            for (j=k;j<n-k+1;j++)
                if ( matrix[j][m-k] == 0) matrix[j][m-k]=i++;/*По правому вертикальному столбцу*/
            for (j=m-k-1;j>=k-1;--j)
                if (matrix[n-k][j] == 0) matrix[n-k][j]=i++;/*по нижнему горизонтальному столбцу*/
            for (j=n-k-1;j>=k;j--)
                if (matrix[j][k-1] == 0) matrix[j][k-1]=i++;/*по левому вертикальному столбцу*/
        }

        Output(matrix, n, m);


        System.out.println();

        //Змейкой
        int counter2 = 1;
        int[][] matrix3 = new int[n][m];
        for(i=0;i<m;i++)
        {
            if (i%2 == 0)
            for (j = 0; j < n; j++)
                matrix3[j][i] = counter2++;
            else
            for (j = n - 1; j >= 0; j--)
                matrix3[j][i] = counter2++;
        }

        Output(matrix3, n, m);

        }
        public static void Output(int[][] arr, int n, int m)
            {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.printf("%4d",arr[i][j]);
                    }
                    System.out.println();
                }
            }

}


