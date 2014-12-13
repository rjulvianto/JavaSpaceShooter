//package com.kopitiamstudio.spaceimpact;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameStage extends JPanel implements Runnable, KeyListener {
    private Thread thread;

    private BufferedImage image; //the canvas
    private Graphics2D g; //the paintbrush

    //GAMESTATE
    private boolean running;
    private boolean gameOver;

    public GameStage() {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void startGame() {
        //prepare the stage
        image = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

		//set anti aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //VARIABLE INITIALIZE
        gameOver = false;

        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }

        addKeyListener(this);
    }

    @Override
    public void run() {
        running = true;

        long runStart = 0;
        long runElapsed = 0;
        long waitTime = 0;
        long msPerFrame = 1000/30; //30 FPS
        while(running) {
            runStart = System.nanoTime(); //catat waktu mulai
			
			//aktual kalkulasi dalam game untuk setiap framenya
            gameUpdate();
            gameRender();
            gameDraw();

			//hitung waktu yang terpakai untuk kalkulasi game
            runElapsed = (System.nanoTime() - runStart) / 1000000;
            waitTime = msPerFrame - runElapsed;
            try {
                if(waitTime > 0) {
					//tunggu hingga target waktu tercapai
                    Thread.sleep(waitTime);
                }
            }
            catch(Exception e) {
            }
        }
    }

    private void gameUpdate() {
        if(!gameOver) {
			//update all Actor and GameObject status
        }
    }

    private void gameRender() {
        if(gameOver) {
            //show "-- G A M E  O V E R --"
        }
        else {
			//draw semua GameObject ke kanvas
			
			//draw background
			g.setColor(new Color(220, 220, 220));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        }
    }

    private void gameDraw() {
        //transfer image dari kanvas ke layar
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent key) {
    }
    @Override
    public void keyPressed(KeyEvent key) {
        int keyCode = key.getKeyCode();
    }
    @Override
    public void keyReleased(KeyEvent key) {
        int keyCode = key.getKeyCode();
    }
}