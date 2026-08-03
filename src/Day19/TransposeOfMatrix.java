package Day19;

public class TransposeOfMatrix {

    public static void main(String[] args) {

        int a[][] = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int result[][] = new int[a[0].length][a.length];

        // Transpose Logic
        for (int row = 0; row < a.length; row++) {

            for (int col = 0; col < a[0].length; col++) {

                result[col][row] = a[row][col];

            }

        }

        // Print Original Matrix
        System.out.println("Original Matrix:");

        for (int row = 0; row < a.length; row++) {

            for (int col = 0; col < a[0].length; col++) {

                System.out.print(a[row][col] + " ");

            }

            System.out.println();

        }

        // Print Transpose Matrix
        System.out.println("\nTranspose Matrix:");

        for (int row = 0; row < result.length; row++) {

            for (int col = 0; col < result[0].length; col++) {

                System.out.print(result[row][col] + " ");

            }

            System.out.println();

        }

    }

}