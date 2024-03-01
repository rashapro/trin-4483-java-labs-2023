package rinthaisong.trin.lab10;

/**
 * This program is PlayerFormV9
 * Show a window, titled "Player Form V9"
 * This program displays results similar to PlayerFormV8.
 * Class PlayerFormV9 which inherited from PlayerFormV8.
 * Show number of yearSlide 
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/3/2024
 **/
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    public PlayerFormV9(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void addComponents() {
        super.addComponents();
    } // เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");// กำหนดชื่อให้ PlayerFormV4 และส่งค่า title ไปยังเมธอด
                                                              // PlayerFormV4
        msw.addComponents();// เรียกใช้เมธอด addComponents
        msw.addListeners();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
        msw.setFrameFeatures();// เรียกใช้เมธอด setFrameFeatures() ที่ extends มาจาก superClass
    }

    public void addListeners() {
        super.addListeners();
        experienceSlider.addChangeListener(this);
    } // เพิ่มส่วนของตัวดำเนินการ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }// ใช้สำหรับ Run โปรแกรม

    @Override
    public void stateChanged(ChangeEvent e) {
        if (!experienceSlider.getValueIsAdjusting()) {
            int yearNum = experienceSlider.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + yearNum);
        }
    }
}