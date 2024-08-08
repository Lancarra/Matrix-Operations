import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        // Filling the matrix with random numbers from 1 to 50
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        // Displaying the matrix in the form of a table
        System.out.println("Matrix 4x4: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Sum of elements in even and odd rows
        int sumEvenRows = 0;
        int sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        // Product of elements in even and odd columns
        int productEvenColumns = 1;
        int productOddColumns = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    productEvenColumns *= matrix[i][j];
                } else {
                    productOddColumns *= matrix[i][j];
                }
            }
        }

        // Displaying the results
        System.out.println("The sum of the elements in even rows: " + sumEvenRows);
        System.out.println("The sum of elements in odd rows: " + sumOddRows);
        System.out.println("Product of elements in even columns: " + productEvenColumns);
        System.out.println("Product of elements in odd columns: " + productOddColumns);

        // Check for a magic square
        if (isMagicSquare(matrix)) {
            System.out.println("The matrix is a magic square.");
        } else {
            System.out.println("A matrix is not a magic square.");
        }
    }

    // Method for checking for a magic square
    public static boolean isMagicSquare(int[][] matrix) {
        int sumDiagonal1 = 0, sumDiagonal2 = 0;
        int[] sumRows = new int[4];
        int[] sumColumns = new int[4];

        // Calculate the sum of the main and side diagonals, rows, and columns
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sumRows[i] += matrix[i][j];
                sumColumns[j] += matrix[i][j];
                if (i == j) {
                    sumDiagonal1 += matrix[i][j];
                }
                if (i + j == 3) {
                    sumDiagonal2 += matrix[i][j];
                }
            }
        }

        // Check for equality of all amounts
        for (int i = 1; i < 4; i++) {
            if (sumRows[i] != sumRows[0] || sumColumns[i] != sumColumns[0]) {
                return false;
            }
        }

        return sumDiagonal1 == sumDiagonal2 && sumDiagonal1 == sumRows[0];
    }
}