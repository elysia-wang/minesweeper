public class Minesweeper
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] mine = new boolean[m + 2][n + 2];
        int[][] count = new int[m + 2][n + 2];

        // randomly place mines
        for (int i = 0; i < k; i++)
        {
            int x = (int) (Math.random() * (m)) + 1;
            int y = (int) (Math.random() * (n)) + 1;

            if (!mine[x][y])
                mine[x][y] = true;
            else
                i--;
        }

        // count neighbouring mines
        for (int a = 1; a < (m + 1); a++)
        {
            for (int b = 1; b < (n + 1); b++)
            {
                int tally = 0;

                if (mine[a + 1][b + 1])
                    tally++;
                if (mine[a - 1][b])
                    tally++;
                if (mine[a + 1][b])
                    tally++;
                if (mine[a + 1][b - 1])
                    tally++;
                if (mine[a - 1][b + 1])
                    tally++;
                if (mine[a][b + 1])
                    tally++;
                if (mine[a][b - 1])
                    tally++;
                if (mine[a - 1][b - 1])
                    tally++;

                count[a][b] = tally;
            }
        }
        for (int p = 1; p < (m + 1); p++)
        {
            for (int q = 1; q < (n + 1); q++)
            {
                if (mine[p][q] == true)
                    System.out.print("*  ");
                else
                    System.out.print(count[p][q] + "  ");
            }
            System.out.println();
        }
    }

}

