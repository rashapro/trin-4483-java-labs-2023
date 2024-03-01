package rinthaisong.trin.lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class PlayerFormV11 extends PlayerFormV10 implements ActionListener {
    protected File file;
    protected JFileChooser fc;

    // ประกาศตัวแปร
    public PlayerFormV11(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void initComponents() {
        super.initComponents();// เรียกใช้เมธอด initComponents() จากคลาส super หรือก็คือคลาส PlayerFormV3
        fc = new JFileChooser();
    }// กำหนดส่วนเริ่มของตัวแปรแต่ละตัว

    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");// กำหนดชื่อให้ PlayerFormV4 และส่งค่า title ไปยังเมธอด
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
    } // เพิ่มส่วนของตัวดำเนินการ

    public void addMenus() {
        super.addMenus();
        fileMenuOpen.setMnemonic(KeyEvent.VK_O);
        fileMenuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        fileMenuSave.setMnemonic(KeyEvent.VK_S);
        fileMenuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        fileMenuExit.setMnemonic(KeyEvent.VK_X);
        fileMenuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    } // เพิ่มในส่วนของคีย์ทางลัด

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
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                openFile();
            } else {
                JOptionPane.showMessageDialog(this, "Open command cancelled by user");
            }
        } else if (srcObj == fileMenuSave) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                saveFile();
            } else {
                JOptionPane.showMessageDialog(this, "Save command cancelled by user");
            }
        } else if (srcObj == fileMenuExit) {
            System.exit(0);
        }
    }// การดำเนินการของตัวดำเนินการ

    public void saveFile() {
        JOptionPane.showMessageDialog(this, "Save file " + file.getName());
    } // for lab11

    public void openFile() {
        JOptionPane.showMessageDialog(this, "Open file " + file.getName());
    } // for lab11
}