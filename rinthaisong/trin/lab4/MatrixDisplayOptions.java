package rinthaisong.trin.lab4;

import java.util.*;

public class MatrixDisplayOptions {
    static int[][] matrix;
    static int rows;
    static int columns;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayOptions(); // subroutine ให้เลือก choice
        int choice = getUserChoice(); // ให้แสดงผลตาม choice ที่เลือก

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

        if (choice >= 1 || choice <= 5) {
            displayMatrix();
        }
    }

    public static int getUserChoice() {
        return scanner.nextInt();
    }

    public static void userInputMatrix() { // subroutine ให้กำหนดค่า matrix เอง
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

    public static void randomMatrix() { // subroutine random ค่าใน matrix
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();

        matrix = new int[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextInt(10); // Random เลขจาก 0-9
            }
        }
    }

    public static void allZerosMatrix() { // subroutine ที่ให้ค่าทุกค่าใน matrix เป็น 0
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();
        matrix = new int[rows][columns]; // เป็น 0 เนื่องจากไม่เพิ่มค่าให้
    }

    public static void allOnesMatrix() { // subroutine ที่ให้ค่าทุกค่าใน matrix เป็น 1
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 1; // แทนทั้งหมดใน matrix เป็น 1
            }
        }
    }

    public static void diagonalMatrix() { // subroutine ที่ให้ค่าใน matrix เป็น diagonal matrix
        System.out.print("Enter the number of rows and colums for diagonal matrix: ");
        int size = scanner.nextInt();

        rows = size;
        columns = size;

        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1; // ถ้า rows = columns กำหนดให้ค่าเป็น 1 ที่เหลือเป็น 0
        }
    }

    public static void displayMatrix() { // subroutine ใช้แสดงค่า matrix
        System.out.println("Displaying Matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayOptions() { // subroutine ใช้แสดง choice ให้เลือก
        System.out.println("Matrix Creation Options");
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter choice (1-5): ");
    }
}