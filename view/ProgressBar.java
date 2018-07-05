package heapsort.view;

import javax.swing.*;

public class ProgressBar extends JPanel {
    private int currentSlide = 0;
    private int countOfSlides = 0;
    private JLabel label = new JLabel();

    public ProgressBar(){
        add(label);
    }

    void increaseCurrentSlide(){
        this.currentSlide += 1;
        printText();
    }

    void printText(){
        label.setText(currentSlide + "/" + countOfSlides);
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

    public void clear(){
        currentSlide = 0;
        countOfSlides = 0;
    }
}
