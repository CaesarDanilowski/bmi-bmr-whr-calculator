package com.cezarydanilowski;

import javax.swing.*;
import java.awt.*;

public class View {

    public static void addNorthPanel(DieteticFrame frame, JPanel personalPanel, JPanel northPanel, JTextField height, JTextField weight, JTextField age, JTextField waist, JTextField hips) {
        personalPanel.add(new JLabel("Height (cm)", SwingConstants.RIGHT));
        personalPanel.add(height);

        personalPanel.add(new JLabel("Weight (kg)", SwingConstants.RIGHT));
        personalPanel.add(weight);

        personalPanel.add(new JLabel("Age (years)", SwingConstants.RIGHT));
        personalPanel.add(age);

        personalPanel.add(new JLabel("Waist (cm)", SwingConstants.RIGHT));
        personalPanel.add(waist);

        personalPanel.add(new JLabel("Hips (cm)", SwingConstants.RIGHT));
        personalPanel.add(hips);

        northPanel.add(personalPanel);

        frame.add(northPanel, BorderLayout.NORTH);
    }

    public static void addGenderPanel(DieteticFrame frame, JPanel northPanel, JPanel personalPanel, ButtonGroup gender, JRadioButton male, JRadioButton female) {
        gender.add(male);
        gender.add(female);

        personalPanel.add(male);
        personalPanel.add(female);

        northPanel.add(personalPanel);
        northPanel.add(new DrawLine());
        frame.add(northPanel, BorderLayout.NORTH);

        male.addActionListener(event -> frame.setANNormalWHR(5, (float) 1.0));
        female.addActionListener(event -> frame.setANNormalWHR(161, (float) 0.7));
    }

    public static void addResultPanel(DieteticFrame frame, JPanel northPanel, JPanel resultPanel, JButton bmi, JButton bmr, JButton whr, JLabel bmiIsCorrect, JLabel whrIsCorrect, JLabel checkData) {
        resultPanel.add(new JLabel("BMI", SwingConstants.RIGHT));
        bmi.setEnabled(false);
        bmi.setSize(new Dimension(40, 10));
        resultPanel.add(bmi);

        resultPanel.add(new JLabel("BMR (kcal)", SwingConstants.RIGHT));
        bmr.setEnabled(false);
        bmr.setSize(new Dimension(40, 10));
        resultPanel.add(bmr);

        resultPanel.add(new JLabel("WHR", SwingConstants.RIGHT));
        whr.setEnabled(false);
        whr.setSize(new Dimension(40, 10));
        resultPanel.add(whr);

        northPanel.add(resultPanel);
        frame.add(northPanel, BorderLayout.NORTH);
    }
}
