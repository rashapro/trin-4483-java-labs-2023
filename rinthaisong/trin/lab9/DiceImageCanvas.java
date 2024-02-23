package rinthaisong.trin.lab9;

/**
 * This program is DiceImageCanvas
 * This program is adapted from the template of the class attached to the problem.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 23/2/2024
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;

    // ประกาศตัวแปร
    public DiceImageCanvas(int diceNumber) {
        this.diceNumber = diceNumber;
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);// initialize a rectangle
                                                                                               // which is a background
        createCircles();// call method createCircles to place dots on a rectangle
    }// รับค่าแต้มของลูกเต๋า

    protected void createCircles() {
        circleCenter = new Ellipse2D.Double((startSquareX + (squareWidth / 2) - (circleWidth / 2)),
                (startSquareY + (squareHeight / 2) - (circleHeight / 2)), circleWidth, circleHeight);
        circleTopCenter = new Ellipse2D.Double((startSquareX + (squareWidth / 2) - (circleWidth / 2)),
                (startSquareY + margin), circleWidth, circleHeight);
        circleTopLeft = new Ellipse2D.Double((startSquareX + margin), (startSquareY + margin), circleWidth,
                circleHeight);
        circleTopRight = new Ellipse2D.Double((startSquareX + (squareWidth) - (circleWidth + margin)),
                (startSquareY + margin), circleWidth, circleHeight);
        circleBottomCenter = new Ellipse2D.Double((startSquareX + (squareWidth / 2) - (circleWidth / 2)),
                (startSquareY + (squareHeight) - (circleHeight + margin)), circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double((startSquareX + margin),
                ((startSquareY + (squareHeight - circleHeight) - margin)), circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double((startSquareX + (squareWidth) - (circleWidth + margin)),
                (startSquareY + (squareHeight) - (circleHeight + margin)), circleWidth, circleHeight);
        ;// fill red on all circles that will be placed on a rectangle
    }// กำหนดขนาดและตำแหน่งของวงกลม

    protected void drawDiceNumber() {
        if (diceNumber == 1) {
            g2d.fill(circleCenter);// วาดวงกลมและระบายสีที่กำหนด
        } else if (diceNumber == 2) {
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
        } else if (diceNumber == 3) {
            g2d.fill(circleCenter);
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
        } else if (diceNumber == 4) {
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleTopLeft);
            g2d.fill(circleBottomRight);
        } else if (diceNumber == 5) {
            g2d.fill(circleCenter);
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleTopLeft);
            g2d.fill(circleBottomRight);
        } else if (diceNumber == 6) {
            g2d.fill(circleBottomCenter);
            g2d.fill(circleTopCenter);
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleTopLeft);
            g2d.fill(circleBottomRight);
        } // depending on a dice number, place red dots properly on a rectangle
    }// แสดงแต้มของลูกเต๋าตามแต้มของลูกเต๋าที่รับมา

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// call paintComponent of super class
        g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);// กำหนดสี
        g2d.fill(square);// วาดสี่เหลี่ยมและระบายสีที่กำหนด
        g2d.setColor(Color.RED);// กำหนดสี
        drawDiceNumber();// วาดวงกลมและระบายสีที่กำหนด
    }
}