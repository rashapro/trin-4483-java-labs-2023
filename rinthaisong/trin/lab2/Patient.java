package rinthaisong.trin.lab2;

/**
 * The Patient Progarm :
 * This program accepts three arguments
 * and displays patient information.
 * The output should be
 * Patient's name : <patient_name>
 * Nationality : <patient_age>
 * Gender : <patient_gender>
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 24/11/2023
 */
public class Patient {
    public static void main(String[] args) {
        int numArg = args.length;
        if (numArg != 3) {
            System.out.println("Invalid number of arguments. Please provide exactly three arguments.");
            System.exit(0);
        }
        String name = args[0];
        String age = args[1];
        String gender = args[2];
        System.out.println("Pateint's name :" + name);
        System.out.println("Age : " + age);
        System.out.println("Gender : " + gender);
    }
}