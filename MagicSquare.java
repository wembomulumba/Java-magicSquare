package Trees;

public class MagicSquare {

    final int squareArray[][];
    final boolean used[];
    final int n;
    final int magicSum;
    public MagicSquare(int n) {
        squareArray = new int[n][n];
        this.n = n;
        used = new boolean[n*n+1];
        magicSum = n*(n*n+1)/2;
    }
    boolean isValid() {
        int sumD1 = 0;
        int sumD2 = 0;
        for (int i = 0; i < n; i++) {
            int sumR = 0;
            int sumC = 0;
            sumD1 += squareArray[i][i];
            sumD2 += squareArray[i][n-i-1];
            for (int j = 0; j < n; j++) {
                sumR += squareArray[i][j];
                sumC += squareArray[j][i];
            }
            if (sumR != magicSum || sumC != magicSum) { return false; }
        }
// diagonals
        return (sumD1 == magicSum && sumD2 == magicSum);
    }
    boolean solve(int step) {
        if (step == n*n) {
            return isValid();
        }
        for (int val = 1; val <= n*n; val++) {
            if (used[val]) { continue; }
            used[val] = true;
            squareArray[step/n][step%n] = val;
            if (solve(step+1)) {
                return true;
            }
            squareArray[step/n][step%n] = 0;
            used[val] = false;
        }
        return false;
    }
    boolean validUpTo(int step) {
        for (int r = 0; r < n; r++) {
            if (step == (r+1)*n-1) {
                int sum = 0;
                for (int c = 0; c < n; c++) { sum += squareArray[r][c]; }
                return (sum == magicSum);
            }
        }
        for (int c = 0; c < n; c++) {
            if (step == n*(n-1)+c) {
                int sum = 0;
                for (int r = 0; r < n; r++) { sum += squareArray[r][c]; }
                return (sum == magicSum);
            }
        }
        return true;
    }
    public void outputSlt () {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(squareArray[r][c]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }
}