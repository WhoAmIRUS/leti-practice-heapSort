package com.etu.heapsort.controller;

import com.etu.heapsort.model.Model;
import com.etu.heapsort.swing.SwingGraphicsAdapter;
import com.etu.heapsort.view.View;
import com.etu.heapsort.swing.ProjectLauncher;

public class Controller{
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void sortMax(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        Model.clearListOfTrees();
        ProjectLauncher.getProgressBar().clear();
        model.sortMax();
        restartView();
    }

    public void sortMin(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        Model.clearListOfTrees();
        ProjectLauncher.getProgressBar().clear();
        model.sortMin();
        restartView();
    }

    public void nextStep(){
        this.view.nextStep();
    }

    public void previousStep(){
        view.previousStep();
    }

    public void automaticSort(){
        View.isAutomaticSort = !View.isAutomaticSort;
    }
  
    public Model getModel() {
        return model;
    }

    private void restartView(){
        if (this.view.isAlive()) this.view = null;
        this.view = new View();
        this.view.setGraphics(new SwingGraphicsAdapter(ProjectLauncher.getCanvas().getGraphics()));
        this.view.start();
    }
}
