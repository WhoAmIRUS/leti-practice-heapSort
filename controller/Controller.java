package com.etu.heapsort.controller;

import com.etu.heapsort.model.Model;
import com.etu.heapsort.view.View;
import com.etu.heapsort.swing.ProjectLauncher;

public class Controller {
    private Model model;
    private final View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void sortMax(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        model.sortMax();
        view.draw(model.getTree());
    }

    public void sortMin(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        model.sortMin();
        view.draw(model.getTree());
    }

    public void nextStep(){
        model.nextStep();
    }

    public void refresh(){
        ProjectLauncher.initScanner();
        view.draw(model.getTree());
    }

    public void automaticSort(){
        Model.isAutomaticSort = !Model.isAutomaticSort;
    }

    public Model getModel() {
        return model;
    }

    public static void changeAnswer(String answer){
        ProjectLauncher.getControls().getLabel().setText("Answer: " + answer);
    }
}
