package com.etu.heapsort.swing;

import com.etu.heapsort.controller.Controller;
import com.etu.heapsort.model.Model;
import com.etu.heapsort.view.ProgressBar;
import com.etu.heapsort.view.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectLauncher extends JFrame {

    private static Scanner scanner;
    private static final Component canvas = new JPanel();
    private static final ControlPanel controls = new ControlPanel();
    private static final ProgressBar progressBar = new ProgressBar();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProjectLauncher().setVisible(true));
    }

    public static void initScanner(){
        scanner = new Scanner(ProjectLauncher.class.getResourceAsStream("./../input.dat"));
    }

    /**
     * Отрисовывыет холст
     */
    public ProjectLauncher(){
        canvas.setPreferredSize(new Dimension(900, 600));
        controls.setPreferredSize(new Dimension(900, 80));
        progressBar.setPreferredSize(new Dimension(900, 50));

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        rootPanel.setPreferredSize(new Dimension(900, 730));

        rootPanel.add(controls, BorderLayout.NORTH);
        rootPanel.add(canvas, BorderLayout.CENTER);
        rootPanel.add(progressBar, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        initListeners();
    }

    /**
     * Ставит слушателей на кнопки
     */
    private void initListeners() {
        initScanner();
        ArrayList<Integer> buffer = new ArrayList<>();
        while(scanner.hasNextInt()){
            buffer.add(scanner.nextInt());
        }
        Model model = Model.restore(buffer);
        View view = new View();
        view.setGraphics(new SwingGraphicsAdapter(canvas.getGraphics()));

        Controller controller = new Controller(model, view);

        controls.addSortMaxButtonListener(e -> controller.sortMax());
        controls.addSortMinButtonListener(e -> controller.sortMin());
        controls.addPreviousStepButtonListener(e -> controller.previousStep());
        controls.addNextStepButtonListener(e -> controller.nextStep());
        controls.addCheckBoxListener(e -> controller.automaticSort());
    }

    public static ControlPanel getControls() {
        return controls;
    }

    public static Component getCanvas() {
        return canvas;
    }

    public static ProgressBar getProgressBar() {
        return progressBar;
    }
}
