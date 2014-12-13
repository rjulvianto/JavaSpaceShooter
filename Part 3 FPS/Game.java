//package com.kopitiamstudio.spaceimpact;

import javax.swing.JFrame;

public class Game {

    public static int WIDTH = 600;
    public static int HEIGHT = 400;

    public static void main(String[] args) {
        JFrame window = new JFrame("Space Shooter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Game stage
        GameStage stage = new GameStage();

        window.setContentPane(stage);
        window.pack();
        window.setVisible(true);

        stage.startGame();
    }
}