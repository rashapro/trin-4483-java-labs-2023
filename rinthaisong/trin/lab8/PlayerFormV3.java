package rinthaisong.trin.lab8;

/**
 * This program is PlayerFormV3
 * Show a window, titled "Player Form V3"
 * This program displays results similar to PlayerFormV2.
 * program will show choices when click "file" or "config"
 * when click file will show "new", "open", "save" and "exit"
 * when click config will show "color" and "size"
 * And when click color will show "red", "green" and "blue"
 * And when click size will show 16 20 and 24 
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 16/2/2024
 **/
import javax.swing.*;
import rinthaisong.trin.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu menuFile, menuConfig;
    protected JMenuItem fileMenuOpen, fileMenuSave, fileMenuExit;
    JMenuItem fileMenuNew;
    protected JMenuItem configMenuColor, configMenuSize, subMenuColor, subMenuSize;
    protected JMenuItem redFont, greenFont, blueFont, fontSize16, fontSize20, fontSize24;

    // ประกาศตัวแปร
    public PlayerFormV3(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void initComponents() {
        super.initComponents();// เรียกใช้เมธอด initComponents() จากคลาส super หรือก็คือคลาส PlayerFormV3
        subMenuColor = new JMenuItem();
        subMenuSize = new JMenuItem();
        menuFile = new JMenu("File");
        menuConfig = new JMenu("Config");
        menuBar = new JMenuBar();
        fileMenuNew = new JMenuItem("New");
        fileMenuOpen = new JMenuItem("Open");
        fileMenuSave = new JMenuItem("Save");
        fileMenuExit = new JMenuItem("Exit");
        configMenuColor = new JMenu("Color");
        configMenuSize = new JMenu("Size");
        redFont = new JMenuItem("Red");
        greenFont = new JMenuItem("Green");
        blueFont = new JMenuItem("Blue");
        fontSize16 = new JMenuItem("16");
        fontSize20 = new JMenuItem("20");
        fontSize24 = new JMenuItem("24");
    }// กำหนดส่วนเริ่มของตัวแปรแต่ละตัว

    protected void addMenus() {
        menuFile.add(fileMenuNew);
        menuFile.add(fileMenuOpen);
        menuFile.add(fileMenuSave);
        menuFile.addSeparator();
        menuFile.add(fileMenuExit);
        menuConfig.add(configMenuColor);
        menuConfig.add(configMenuSize);
        configMenuColor.add(redFont);
        configMenuColor.add(greenFont);
        configMenuColor.add(blueFont);
        configMenuSize.add(fontSize16);
        configMenuSize.add(fontSize20);
        configMenuSize.add(fontSize24);
        menuBar.add(menuFile);
        menuBar.add(menuConfig);
    }// เพิ่มส่วนประกอบในแถบเมนู

    protected void addComponents() {
        super.addComponents();
        addMenus(); // เรียกใช้เมธอด
        setJMenuBar(menuBar);
    }// เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");// กำหนดชื่อให้ PlayerFormV3 และส่งค่า title ไปยังเมธอด
                                                              // PlayerFormV4
        msw.addComponents();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
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