package com.etu.heapsort.controller;

import com.etu.heapsort.model.Model;
import com.etu.heapsort.view.View;
import com.etu.heapsort.swing.ProjectLauncher;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void sortMax(){
        model.sortMax();
        view.draw();
    }

    public void sortMin(){
        model.sortMin();
        view.draw();
    }

    public void nextStep(){
        model.nextStep();
    }

    public void refresh(){
        ProjectLauncher.initScanner();
        view.draw();
    }

    public void automaticSort(){
        model.isAutomaticSort = !model.isAutomaticSort;
    }
}
