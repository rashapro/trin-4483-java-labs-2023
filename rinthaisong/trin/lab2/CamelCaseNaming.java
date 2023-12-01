package rinthaisong.trin.lab2;

/**
 * The Camel Case Naming Progarm :
 * This program accepts two arguments
 * and displays information in Camel Case.
 * By changing the first letter of each word to uppercase
 * and the remaining letters to lowercase.
 * Verify that exactly two arguments are provided.
 * If not, display an error message and exit the program.
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 24/11/2023
 */
public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Please provide exactly two arguments.");
            return;
        }

        String nameStr1 = args[0];
        String nameStr2 = args[1];

        String camelCaseName1 = convertToCamelCase(nameStr1); // ใช้ method convertToCamelCase เพื่อแปลงข้อความ
        String camelCaseName2 = convertToCamelCase(nameStr2);

        String camelCaseName = camelCaseName1 + camelCaseName2;

        System.out.println("Camel Case Resuit: " + camelCaseName);
    }

    public static String convertToCamelCase(String word) { // สร้าง method ที่ใช้แปลงข้อความเป็น Camel Case
        if (word.isEmpty()) { // ตรวจสอบ string ที่รับเข้ามา หากไม่มีจะส่งกลับไปรับค่าใหม่อีกรอบ
            return "";
        } else {
            String firstLetter = word.substring(0, 1).toUpperCase(); // จะดึงตัวอักษรตัวแรกแล้วแปลงเป็นตัวใหญ่
            String restWord = word.substring(1).toLowerCase(); // จะดึงส่วนที่เหลือแล้วแปลงเป็นตัวเล็กทั้งหมด
            return firstLetter + restWord;
        }
    }
}