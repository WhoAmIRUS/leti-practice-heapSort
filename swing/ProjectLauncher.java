package com.etu.heapsort.swing;

import javax.swing.*;
import java.util.Scanner;

public class ProjectLauncher extends JFrame {

    public Scanner scanner;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProjectLauncher().setVisible(true));
    }

    public void initScanner(){
        scanner = new Scanner(ProjectLauncher.class.getResourceAsStream("./../input.dat"));
    }

    /**
     * Отрисовывыет холст
     */
    public ProjectLauncher(){
        initListeners();
    }

    /**
     * Ставит слушателей на кнопки
     */
    private void initListeners() {
        initScanner();
    }
}
