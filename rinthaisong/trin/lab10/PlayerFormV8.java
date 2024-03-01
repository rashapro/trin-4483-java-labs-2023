package rinthaisong.trin.lab10;

/**
 * This program is PlayerFormV8
 * Show a window, titled "Player Form V8"
 * This program displays results similar to PlayerFormV7.
 * Class PlayerFormV8 which inherited from PlayerFormV7.
 * More on the part of the action when choosing a games.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/3/2024
 **/
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.util.List;
import rinthaisong.trin.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {

    public PlayerFormV8(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void addComponents() {
        super.addComponents();
        sportList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // สามารถเลือกได้มากกว่า1
    } // เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");// กำหนดชื่อให้ PlayerFormV4 และส่งค่า title ไปยังเมธอด
                                                              // PlayerFormV4
        msw.addComponents();// เรียกใช้เมธอด addComponents
        msw.addListeners();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
        msw.setFrameFeatures();// เรียกใช้เมธอด setFrameFeatures() ที่ extends มาจาก superClass
    }

    public void addListeners() {
        super.addListeners();
        sportList.addListSelectionListener(this);
    } // เพิ่มส่วนของตัวดำเนินการ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }// ใช้สำหรับ Run โปรแกรม

    public void valueChanged(ListSelectionEvent e) {
        boolean isAdjusting = e.getValueIsAdjusting();
        StringBuffer message = new StringBuffer();
        if (!isAdjusting) {
            List<String> selectedGame = sportList.getSelectedValuesList();
            int numSelected = selectedGame.size();
            for (int i = 0; i < numSelected; i++) {
                if (i == 0) {
                    message.append("Selected sports are " + selectedGame.get(i));
                } else {
                    message.append(", " + selectedGame.get(i));
                }
            }
            JOptionPane.showMessageDialog(this, message.toString());
        }
    }// การดำเนินการของตัวดำเนินการเมื่อเลือกเกม
}