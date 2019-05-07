package com.cezarydanilowski;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class DrawLine extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Line2D seperate = new Line2D.Double(10, 20, 485, 20);
        g2.draw(seperate);
    }
}
