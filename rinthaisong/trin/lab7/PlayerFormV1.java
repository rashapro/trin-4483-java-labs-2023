package rinthaisong.trin.lab7;

/**
 * This program is PlayerFormV1
 * Show a window, titled "Player Form V1"
 * This program provides a panel for storing your name, nationality, date of birth and gender.
 * This window will display the "Reset" and "Submit" buttons
 * Class PlayerFormV1 which inherited from MySimpleWindow.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 **/
import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {
    protected final int TEXT_FIELD_LENGTH = 15;
    protected JTextField nameTxt, nationalityTxt, birthTxt;
    protected JRadioButton maleRButton, femaleRButton;
    protected JPanel namePanel, nationalityPanel, birthPanel, genderPanel, contentsPanel, gendersPanel, contentsPanel2;
    protected JLabel nameLabel, nationalityLabel, birthLabel, genderLabel;
    protected ButtonGroup genderGroup;
    protected GridLayout layout;
    // ประกาศตัวแปร

    public PlayerFormV1(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void initComponents() {
        super.initComponents(); // เรียกใช้เมธอด initComponents() จากคลาส super หรือก็คือคลาส MySimpleWindow
        contentsPanel2 = new JPanel();
        namePanel = new JPanel();
        nationalityPanel = new JPanel();
        birthPanel = new JPanel();
        genderPanel = new JPanel();
        contentsPanel = new JPanel();
        gendersPanel = new JPanel();
        // ประกาศส่วนเริ่มของ Panel
        nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality:");
        birthLabel = new JLabel("Date of Birth (eg.,31-01-2005):");
        genderLabel = new JLabel("Gender:");
        // กำหนดข้อความ(Label)
        nameTxt = new JTextField(TEXT_FIELD_LENGTH);
        nationalityTxt = new JTextField(TEXT_FIELD_LENGTH);
        birthTxt = new JTextField(TEXT_FIELD_LENGTH);
        // กำหนดขนาดให้กับช่องข้อความ(Text Field)
        femaleRButton = new JRadioButton("Male");
        maleRButton = new JRadioButton("Female", true);
        // กำหนดข้อความให้ปุ่มตัวเลือก(Radio Button)
        genderGroup = new ButtonGroup();// จัดกลุ่มของปุ่มตัวเลือกเพื่อให้เลือกได้แค่ 1 ปุ่ม
        layout = new GridLayout(0, 2);// กำหนดขนาดของ layout
    }// กำหนดส่วนเริ่มของตัวแปรแต่ละตัว

    protected void addComponents() {
        super.addComponents();// เรียกใช้เมธอด addComponents() จากคลาส super หรือก็คือคลาส MySimpleWindow
        genderGroup.add(femaleRButton);
        genderGroup.add(maleRButton);
        genderPanel.setLayout(layout);
        gendersPanel.add(femaleRButton);
        gendersPanel.add(maleRButton);
        genderPanel.add(genderLabel);
        genderPanel.add(gendersPanel);
        // เพิ่มองค์ประกอบใน genderPanel
        namePanel.setLayout(layout);
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);
        // เพิ่มองค์ประกอบใน namePanel
        nationalityPanel.setLayout(layout);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(nationalityTxt);
        // เพิ่มองค์ประกอบใน nationalityPanel
        birthPanel.setLayout(layout);
        birthPanel.add(birthLabel);
        birthPanel.add(birthTxt);
        // เพิ่มองค์ประกอบใน birthPanel
        contentsPanel.setLayout(new BorderLayout());
        contentsPanel.add(namePanel, BorderLayout.NORTH);
        contentsPanel.add(nationalityPanel, BorderLayout.CENTER);
        contentsPanel.add(birthPanel, BorderLayout.SOUTH);
        // เพิ่มองค์ประกอบใน contentPanel
        contentsPanel2.setLayout(new BorderLayout());
        contentsPanel2.add(genderPanel, BorderLayout.NORTH);
        // เพิ่มองค์ประกอบใน contentPanel2
        mainPanel.add(contentsPanel, BorderLayout.NORTH);
        mainPanel.add(contentsPanel2, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        // เพิ่มองค์ประกอบใน mainPanel
    }// เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");// กำหนดชื่อให้ PlayerFormV1 และส่งค่า title ไปยังเมธอด
                                                              // PlayerFormV1
        msw.addComponents();// เรียกใช้เมธอด addComponents
        msw.setFrameFeatures();// เรียกใช้เมธอด setFrameFeatures() ที่ extends มาจาก superClass
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }// ใช้สำหรับ Run โปรแกรม
}