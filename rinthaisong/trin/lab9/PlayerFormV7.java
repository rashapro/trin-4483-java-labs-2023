package rinthaisong.trin.lab9;

/**
 * This program is PlayerFormV6
 * Show a window, titled "Player Form V7"
 * This program displays results similar to PlayerFormV6.
 * Class PlayerFormV6 which inherited from PlayerFormV6.
 * More on the part of the action when choosing a gender.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 23/2/2024
 **/
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {
    public PlayerFormV7(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");// กำหนดชื่อให้ PlayerFormV4 และส่งค่า title ไปยังเมธอด
                                                              // PlayerFormV4
        msw.addComponents();// เรียกใช้เมธอด addComponents
        msw.addListeners();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
        msw.setFrameFeatures();// เรียกใช้เมธอด setFrameFeatures() ที่ extends มาจาก superClass
    }

    public void addListeners() {
        super.addListeners();
        maleRButton.addItemListener(this);
        femaleRButton.addItemListener(this);
    } // เพิ่มส่วนของตัวดำเนินการ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }// ใช้สำหรับ Run โปรแกรม

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (maleRButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Female");// เนื่องจากความผิดพลาดชองการตั้งชื่อและตัวแปร
                                                                               // จึงต้องสลับกันระหว่าง Male และ Female
        }
        if (femaleRButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Male");
        }
    } // การดำเนินการของตัวดำเนินการเมื่อเลือกเพศ
}