package rinthaisong.trin.lab4;

import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    static int[][] matrix;
    static int rows;
    static int columns;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        displayOptions(); // subroutine ให้เลือก option
        int choice = getUserChoice(); // ให้แสดงผลตาม option ที่เลือก
        switch (choice) {
            case 1:
                userInputMatrix();
                break;
            case 2:
                randomMatrix();
                break;
            case 3:
                allZerosMatrix();
                break;
            case 4:
                allOnesMatrix();
                break;
            case 5:
                diagonalMatrix();
                break;
            default:
                break;
        }

        while (exit == false) {
            displayOperations(); // subroutine ให้เลือก operation
            int operation = getUserChoice(); // ให้แสดงผลตาม operation ที่เลือก

            switch (operation) {
                case 1:
                    displayTranspose();
                    break;
                case 2:
                    rowColumnSums();
                    break;
                case 3:
                    findMinMax();
                    break;
                case 4:
                    displayDiagonal();
                    break;
                case 5:
                    exit = true;
                default:
                    break;
            }
        }
    }

    // subroutine ทำงานเหมือนกับโปรแกรม MatrixOptions
    static void userInputMatrix() {
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();

        matrix = new int[rows][columns];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    static void randomMatrix() {
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();

        matrix = new int[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
    }

    static void allZerosMatrix() {
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();
        matrix = new int[rows][columns];
    }

    static void allOnesMatrix() {
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and colums for diagonal matrix: ");
        int size = scanner.nextInt();
        rows = size;
        columns = size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public static int getUserChoice() {
        return scanner.nextInt();
    }

    // Matrix operation methods
    public static void displayTranspose() { // Transpose matrix ที่สร้างขี้น
        int[][] transpose = new int[columns][rows]; // สร้างmatrixใหม่โดยสลับ rows กับ columns

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        System.out.println("Transpose matrix:");
        displayMatrix(transpose);
    }

    public static void rowColumnSums() { // รวมค่า rows และ column
        int[] rowSums = new int[rows];
        int[] columnSums = new int[columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowSums[i] += matrix[i][j]; // rowSums เป็นค่า rows ทั้งหมดรวมกัน
                columnSums[j] += matrix[i][j]; // columnSums เป็นค่า columns ทั้งหมดรวมกัน
            }
        }
        System.out.println("Row Sums:"); // แสดงผล rowSums
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + ": " + rowSums[i]);
        }
        System.out.println("Column sums:"); // แสดงผล columnSums
        for (int j = 0; j < columns; j++) {
            System.out.println("Column " + (j + 1) + ": " + columnSums[j]);
        }
    }

    public static void findMinMax() { // หาค่า Min/Max
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
                if (element > max) {
                    max = element;
                }
            }
        }
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }

    public static void displayDiagonal() { // หาค่า diagonal
        System.out.println("Main Diagonal:");
        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void displayOptions() {
        System.out.println("Matrix Creation Options");
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter choice (1-5): ");
    }

    public static void displayOperations() {
        System.out.println("Choose an operation:");
        System.out.println("1. Transpose Matrix");
        System.out.println("2. Row and Column Sum");
        System.out.println("3. Find Min/Max Value");
        System.out.println("4. Diagonal Display");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }
}