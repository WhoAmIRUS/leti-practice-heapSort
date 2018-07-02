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

    }

    public void refresh(){
        new ProjectLauncher().initScanner();
        view.draw();
    }
}
