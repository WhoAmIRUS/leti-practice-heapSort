package heapsort.view;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JPanel {
    private int currentSlide = 0;
    private int countOfSlides = 0;
    private JLabel label = new JLabel();
    private Graphics graphics;

    public ProgressBar(){
        add(label);
    }

    void increaseCurrentSlide(){
        this.currentSlide += 1;
        printText();
        //paint();
    }

    void printText(){
        label.setText(currentSlide + "/" + countOfSlides);
    }

    public void paint() {
        graphics.drawOval(1, 1, 50, 50, Color.black.getRGB());
    }

    void setCurrentSlide(int currentSlide) {
        if (currentSlide < 0){
            throw new IllegalArgumentException("Error: currentSlide must be more than 0");
        }
        this.currentSlide = currentSlide;
        printText();
    }

    void setCountOfSlides(int countOfSlides) {
        this.countOfSlides = countOfSlides;
    }

    public int getCurrentSlide() {
        return currentSlide;
    }

    public void clear(){
        currentSlide = 0;
        countOfSlides = 0;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
