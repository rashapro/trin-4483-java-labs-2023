package rinthaisong.trin.lab2;

/**
 * The Simple Calculator Progarm :
 * This program accepts three arguments
 * The first two will be numbers
 * and the last will be operator(+,-,x,/)
 * Checks if all 3 arguments are entered.
 * If not a warning message will be displayed.
 * Takes fist two number ​​and operators to calculate.
 * Display the results of the calculation.
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 24/11/2023
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Error: Please provide exactly three arguments.");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        char operator = args[2].charAt(0);

        int result = 0;
        String operatorSymbol = "";

        /**
         * ใช้ switch เพื่อดูว่าตัวแปร operator เป็น+,-,x,/
         * เมื่อรู้ว่าเป็นตัวแปรใดจึงดำเนินการต่อไปในแต่ละ case
         */
        switch (operator) {
            case '+':
                result = num1 + num2;
                operatorSymbol = "+"; // เมื่อเป็นcase "+" กำหนดให้ตัวแปร operatorSymbol เป็น +
                break;
            case '-':
                result = num1 - num2;
                operatorSymbol = "-"; // เมื่อเป็นcase "-" กำหนดให้ตัวแปร operatorSymbol เป็น -
                break;
            case 'x':
                result = num1 * num2;
                operatorSymbol = "x"; // เมื่อเป็นcase "x" กำหนดให้ตัวแปร operatorSymbol เป็น x
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    operatorSymbol = "/"; // เมื่อเป็นcase "/" กำหนดให้ตัวแปร operatorSymbol เป็น /
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator. Please use '+', '-'', 'x', or '/'.");
                return;
        }

        System.out.println(num1 + " " + operatorSymbol + " " + num2 + " = " + result);
    }
}