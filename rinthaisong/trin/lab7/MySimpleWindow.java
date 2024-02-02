package rinthaisong.trin.lab7;

/**
 * My simple window Progarm :
 * Show a window, titled "My Simple Window"
 * This window will display the "Reset" and "Submit" buttons
 * Class MySimpleWindow which inherited from JFrame.
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 1/2/2024
 */
import javax.swing.*;

public class MySimpleWindow extends JFrame {
    protected JPanel buttonsPanel, mainPanel;
    protected JButton resetButton, submitButton;

    // ประกาศตัวแปร
    public MySimpleWindow(String title) {
        super(title);
    } // กำหนดชื่อของหน้าต่าง(Title)

    protected void initComponents() {
        submitButton = new JButton("Reset");
        resetButton = new JButton("Submit"); // ใส่ข้อความในปุ่ม
        buttonsPanel = new JPanel();
    } // กำหนดส่วนเริ่มของตัวแปรแต่ละตัว

    protected void addComponents() {
        initComponents(); // เรียกใช้เมธอด initComponents()
        mainPanel = (JPanel) this.getContentPane();
        buttonsPanel.add(submitButton);
        buttonsPanel.add(resetButton);
        // เพิ่มปุ่มเข้าไปใน buttonsPanel
        mainPanel.add(buttonsPanel);
        // เพิ่ม buttonsPanel เข้าไปใน mainPanel
    } // เพิ่มส่วนประกอบต่างๆ

    protected void setFrameFeatures() {
        this.pack(); // ทำให้หน้าต่างของโปรแกรมพอดีกับองค์ประกอบ
        this.setLocationRelativeTo(null); // แสดงหน้าต่างโปรแกรมตรงกลางหน้าจอ
        this.setVisible(true); // แสดงหน้าต่างโปรแกรม
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ทำการปิดโปรแกรมเมื่อออกจากหน้ต่างโปรแกรม
    } // กำหนดคุณสมบัติ(Features)ของหน้าต่าง

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window"); // กำหนดชื่อให้ MySimpleWindow และส่งค่า title
                                                                     // ไปยังเมธอด MySimpleWindow
        msw.addComponents(); // เรียกใช้เมธอด
        msw.setFrameFeatures(); // เรียกใช้เมธอด
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } // ใช้สำหรับ Run โปรแกรม
}