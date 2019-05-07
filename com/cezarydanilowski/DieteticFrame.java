package com.cezarydanilowski;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DieteticFrame extends JFrame {

    private JPanel northPanel = new JPanel(new GridLayout(6,1));
    private JPanel personalPanel = new JPanel(new GridLayout(2, 6));
    private JPanel resultPanel = new JPanel(new GridLayout(1, 6));
    private JPanel isHealthy = new JPanel(new GridLayout(1, 2));
    private JTextField height = new JTextField();
    private JTextField weight = new JTextField();
    private JTextField age = new JTextField();
    private JTextField waist = new JTextField();
    private JTextField hips = new JTextField();
    private ButtonGroup gender = new ButtonGroup();
    private JRadioButton male = new JRadioButton("Male", true);
    private JRadioButton female = new JRadioButton("Female", false);
    private JButton bmi = new JButton("0.0");
    private JButton bmr = new JButton("0.0");
    private JButton whr = new JButton("0.0");
    private JButton apply = new JButton("Apply");
    private JLabel bmiIsCorrect = new JLabel("", SwingConstants.CENTER);
    private JLabel whrIsCorrect = new JLabel("", SwingConstants.RIGHT);
    private JLabel checkData = new JLabel("", SwingConstants.CENTER);
    private int a = 5;
    private float normalWHR = 1;

    public DieteticFrame() {
        View.addNorthPanel(this, personalPanel, northPanel, height, weight, age, waist, hips);
        View.addGenderPanel(this, northPanel, personalPanel, gender, male, female);
        View.addResultPanel(this, northPanel, resultPanel, bmi, bmr, whr, bmiIsCorrect, whrIsCorrect, checkData);

        isHealthy.add(bmiIsCorrect);
        isHealthy.add(whrIsCorrect);
        northPanel.add(isHealthy);

        checkData.setForeground(Color.RED);
        checkData.setVisible(false);
        northPanel.add(checkData);
        add(northPanel);

        apply.setBackground(Color.GREEN);
        apply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        apply.addActionListener(new ApplyAction());
        add(apply, BorderLayout.SOUTH);
    }

    public void setANNormalWHR(int a, float normalWHR) {
        this.a = a;
        this.normalWHR = normalWHR;
    }

    private class ApplyAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (height.getText().isEmpty() || weight.getText().isEmpty() || age.getText().isEmpty() || waist.getText().isEmpty() || hips.getText().isEmpty()) {
                bmiIsCorrect.setVisible(false);
                whrIsCorrect.setVisible(false);
                checkData.setVisible(true);
                checkData.setText("Fill all vields!");
            } else {
                try {
                    bmi.setText(String.valueOf(Counts.countBMI(Float.parseFloat(weight.getText()), Float.parseFloat(height.getText()))));
                    bmr.setText(String.valueOf(Counts.countBMR(Float.parseFloat(weight.getText()), Float.parseFloat(height.getText()), Integer.parseInt(age.getText()), a)));
                    whr.setText(String.valueOf(Counts.countWHR(Float.parseFloat(waist.getText()), Float.parseFloat(hips.getText()))));

                    checkData.setVisible(false);

                    checkingOfHealth();
                } catch (NumberFormatException e) {
                    bmiIsCorrect.setVisible(false);
                    whrIsCorrect.setVisible(false);
                    checkData.setVisible(true);
                    checkData.setText("Fields have to have numbers!");
                }
            }
        }

        private void checkingOfHealth() {
            bmiIsCorrect.setVisible(true);
            whrIsCorrect.setVisible(true);

            if (Counts.countBMI(Float.parseFloat(weight.getText()), Float.parseFloat(height.getText())) < 18.5) {
                bmiIsCorrect.setForeground(Color.RED);
                bmiIsCorrect.setText("Too low");
            } else if (Counts.countBMI(Float.parseFloat(weight.getText()), Float.parseFloat(height.getText())) >= 18.5 && Counts.countBMI(Float.parseFloat(weight.getText()), Float.parseFloat(height.getText())) <= 24.9) {
                bmiIsCorrect.setForeground(Color.GREEN);
                bmiIsCorrect.setText("Correct");
            } else {
                bmiIsCorrect.setForeground(Color.RED);
                bmiIsCorrect.setText("Too many");
            }

            if (Counts.countWHR(Float.parseFloat(waist.getText()), Float.parseFloat(hips.getText())) < normalWHR) {
                whrIsCorrect.setForeground(Color.RED);
                whrIsCorrect.setText("Too low");
            } else if (Counts.countWHR(Float.parseFloat(waist.getText()), Float.parseFloat(hips.getText())) == normalWHR) {
                whrIsCorrect.setForeground(Color.GREEN);
                whrIsCorrect.setText("Correct");
            } else {
                whrIsCorrect.setForeground(Color.RED);
                whrIsCorrect.setText("Too many");
            }
        }
    }
}
