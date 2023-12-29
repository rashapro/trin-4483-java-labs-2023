package rinthaisong.trin.lab4;

import java.util.*;

public class MatrixDisplay {
    static int[][] matrix; // กำหนดตัวแปรเพื่อเก็บค่า matrix
    static int rows; // กำหนดตัวแปรเพื่อเก็บค่า rows
    static int columns; // กำหนดตัวแปรเพื่อเก็บค่า columns

    public static void inputMatrix() { // subroutine ใช้รับค่าinput สร้างพื้นที่เพื่อรอรับค่า matrix
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt(); // รับค่าจำนวน rows
        while (rows <= 0) { // ถ้า rows มีค่าน้อยกว่าหรือเท่ากับ 0 จะให้รับค่าใหม่อีกครั้ง
            System.out.println("Both rows and column must be greater than 0. please try again.");
            rows = scanner.nextInt();
        }
        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt(); // รับค่าจำนวน columns
        while (columns <= 0) { // ถ้า column มีค่าน้อยกว่าหรือเท่ากับ 0 จะให้รับค่าใหม่อีกครั้ง
            System.out.println("Both rows and column must be greater than 0. please try again.");
            columns = scanner.nextInt();
        }
        matrix = new int[rows][columns]; // สร้างพื้นที่เพื่อรอรับค่า matrix
    }

    public static void inputMatrixValue() { // subroutine ใช้รับค่าinput เพื่อรับค่า matrix
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) { // รับค่า matrix จนกว่าจะครบพื้นที่ที่กำหนด
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
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

    public static void main(String[] args) { // methodนี้ใช้รวมsubroutineทั้งสามเพื่อให้โปรแกรมทำงาน
        inputMatrix();
        inputMatrixValue();
        displayMatrix();
    }
}