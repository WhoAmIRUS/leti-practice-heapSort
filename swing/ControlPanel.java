package heapsort.swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private final JLabel enter = createLabel("Size:", 0, 10, 40,30);
    private final JTextField textField = createTextField("", 40, 10, 20, 30);
    private final JButton generate = createButton("Generate",60,10,40,30);
    private final JButton sortMax = createButton("sort from min to max", 60, 10, 190, 30);
    private final JButton sortMin = createButton("sort from max to min", 250, 10, 190, 30);
    private final JButton previousStep = createButton("previous",350,10, 50,30);
    private final JButton nextStep = createButton("next", 450, 10, 50, 30);
    private final JCheckBox checkBox = createCheckBox("Automatic sort", 510, 10, 190, 30);
    private final JLabel answer = createLabel("", 510, 10, 500, 30);

    ControlPanel() {
        add(enter);
        add(textField);
        add(generate);
        add(sortMax);
        add(sortMin);
        add(previousStep);
        add(nextStep);
        add(checkBox);
        add(answer);
    }

    void addGenerateButtonListener(ActionListener listener){
        generate.addActionListener(listener);
    }

    void addSortMaxButtonListener(ActionListener listener){
        sortMax.addActionListener(listener);
    }

    void addSortMinButtonListener(ActionListener listener){
        sortMin.addActionListener(listener);
    }

    void addPreviousStepButtonListener(ActionListener listener) { previousStep.addActionListener(listener); }

    void addNextStepButtonListener(ActionListener listener){
        nextStep.addActionListener(listener);
    }

    void addCheckBoxListener(ActionListener listener){
        checkBox.addActionListener(listener);
    }

    private JButton createButton(String text, int x, int y, int width, int height){
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;
    }

    private JCheckBox createCheckBox(String text, int x, int y, int width, int height){
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setBounds(x, y, width, height);
        return checkBox;
    }

    private JTextField createTextField(String text, int x, int y, int width, int height){
        JTextField textField = new JTextField(text, 4);
        textField.setBounds(x, y, width, height);
        return textField;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    public JTextField getTextField(){
        return textField;
    }

    public JLabel getLabel(){
        return answer;
    }
}


