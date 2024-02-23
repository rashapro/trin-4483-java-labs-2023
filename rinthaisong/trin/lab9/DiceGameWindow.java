package rinthaisong.trin.lab9;

/**
 * This program is DiceGameWindow
 * This program is adapted from the template of the class attached to the problem.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 23/2/2024
 **/
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DiceGameWindow extends JFrame {
    protected DiceImageCanvas diceImageCanvas;
    protected int diceRoll;
    protected JPanel buttonsPanel;
    protected JButton rollButton, highButton, lowButton;
    // ประกาศตัวแปร

    public DiceGameWindow(String title) {
        super(title);
        Random rand = new Random();
        diceRoll = rand.nextInt(6) + 1;
        diceImageCanvas = new DiceImageCanvas(diceRoll);
    }// กำหนดชื่อของหน้าต่าง(Title)

    public void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }// กำหนดคุณสมบัติ(Features)ของหน้าต่าง

    public void addComponents() {
        buttonsPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll");
        highButton = new JButton("High");
        lowButton = new JButton("Low");
        buttonsPanel.add(highButton);
        buttonsPanel.add(lowButton);
        buttonsPanel.add(rollButton);
        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(diceImageCanvas, BorderLayout.CENTER);
    }// เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        DiceGameWindow dgw = new DiceGameWindow("DiceGameWindow Version 1");
        dgw.addComponents();
        dgw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}