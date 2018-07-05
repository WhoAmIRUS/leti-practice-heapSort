package heapsort.swing;

import heapsort.controller.Controller;
import heapsort.model.Model;
import heapsort.view.ProgressBar;
import heapsort.view.View;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectLauncher extends JFrame {

    private static Scanner scanner;
    private static BufferedReader br;
    private static final Component canvas = new JPanel();
    private static final ControlPanel controls = new ControlPanel();
    private static final ProgressBar progressBar = new ProgressBar();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProjectLauncher().setVisible(true));
    }

    public static void initScanner(){
        try {
            br = new BufferedReader(new FileReader("./../input.dat"));
        } catch (Exception e){

        }
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
        ArrayList<Integer> buffer = new ArrayList<>();
        /*try{
            initScanner();
            int line = Integer.parseInt(br.readLine());
            while(line != 0){
                buffer.add(line);
                line = Integer.parseInt(br.readLine());
            }
        } catch (Exception e){

        }*/
        buffer.add(0);
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
