package rinthaisong.trin.lab10;

/**
 * This program is PlayerFormV10
 * Show a window, titled "Player Form V10"
 * This program displays results similar to PlayerFormV9.
 * Class PlayerFormV10 which inherited from PlayerFormV9.
 * More Action of the Menu Bar.
 *      - Choose the color of the text in JTextField
 *      - Choose the size of the text in JTextArea
 * Show text when click option in menus
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/3/2024
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class PlayerFormV10 extends PlayerFormV9 {
    protected File file;
    protected JFileChooser fc;

    // ประกาศตัวแปร
    public PlayerFormV10(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void initComponents() {
        super.initComponents();// เรียกใช้เมธอด initComponents() จากคลาส super หรือก็คือคลาส PlayerFormV3
        fc = new JFileChooser();
    }// กำหนดส่วนเริ่มของตัวแปรแต่ละตัว

    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");// กำหนดชื่อให้ PlayerFormV4 และส่งค่า title ไปยังเมธอด
                                                                 // PlayerFormV4
        msw.addComponents();// เรียกใช้เมธอด addComponents
        msw.addListeners();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
        msw.setFrameFeatures();// เรียกใช้เมธอด setFrameFeatures() ที่ extends มาจาก superClass
    }

    public void addListeners() {
        super.addListeners();
        fileMenuOpen.addActionListener(this);
        fileMenuExit.addActionListener(this);
        fileMenuSave.addActionListener(this);
        redFont.addActionListener(this);
        greenFont.addActionListener(this);
        blueFont.addActionListener(this);
        fontSize16.addActionListener(this);
        fontSize20.addActionListener(this);
        fontSize24.addActionListener(this);
    } // เพิ่มส่วนของตัวดำเนินการ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }// ใช้สำหรับ Run โปรแกรม

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObj = e.getSource();
        if (srcObj == fileMenuOpen) {
            JOptionPane.showMessageDialog(this, "You click menu Open");
        } else if (srcObj == fileMenuSave) {
            JOptionPane.showMessageDialog(this, "You click menu Save");
        } else if (srcObj == fileMenuExit) {
            System.exit(0);
        }
        // เมื่อเรียกใช้เมนู file
        if (srcObj == redFont) {
            nameTxt.setForeground(Color.RED);
            nationalityTxt.setForeground(Color.RED);
            birthTxt.setForeground(Color.RED);
        } else if (srcObj == greenFont) {
            nameTxt.setForeground(Color.GREEN);
            nationalityTxt.setForeground(Color.GREEN);
            birthTxt.setForeground(Color.GREEN);
        } else if (srcObj == blueFont) {
            nameTxt.setForeground(Color.BLUE);
            nationalityTxt.setForeground(Color.BLUE);
            birthTxt.setForeground(Color.BLUE);
        } // เลือกสีของตัวอักษรใน TextField
        if (srcObj == fontSize16) {
            noteText.setFont(new Font(null, Font.PLAIN, 16));
        } else if (srcObj == fontSize20) {
            noteText.setFont(new Font(null, Font.PLAIN, 20));
        } else if (srcObj == fontSize24) {
            noteText.setFont(new Font(null, Font.PLAIN, 24));
        } // เลือกขนาดของตัวอักษรใน JTextArea
          // เมื่อเรียกใช้เมนู config
    }// การดำเนินการของตัวดำเนินการ
}