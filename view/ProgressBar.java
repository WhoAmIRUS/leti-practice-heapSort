package com.etu.heapsort.view;

import javax.swing.*;

public class ProgressBar extends JPanel {
    private int currentSlide;
    private int countOfSlides;
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
