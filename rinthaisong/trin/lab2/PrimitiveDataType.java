package rinthaisong.trin.lab2;

/**
 * The Primitive Data Type Progarm :
 * Different values ​​of variables are assigned to different types of data
 * and displays the value of each variable.
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 24/11/2023
 */
public class PrimitiveDataType {
    public static void main(String[] args) {

        String ID = "653040448-3";
        String Name = "Trin";
        byte ID_2 = 83;
        short ID_3 = 483;
        int ID_6 = 404483;
        long ID_8 = 30404483;
        Float F_ID = (float) 0.483;
        double D_ID = 0.30404483;
        char FirstLetter = Name.charAt(0);
        boolean Id_Odd = true;
        System.out.println("Student ID : " + ID);
        System.out.println("First Name : " + Name);
        System.out.println("Byte Value : " + ID_2);
        System.out.println("Short Value : " + ID_3);
        System.out.println("Int Value : " + ID_6);
        System.out.println("Long Value : " + ID_8);
        System.out.println("Float Value : " + F_ID);
        System.out.println("Double Value : " + D_ID);
        System.out.println("Char Value : " + FirstLetter);
        System.out.println("Boolean Value : " + Id_Odd);
    }
}
