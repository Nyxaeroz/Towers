package com.ThijsProjects.towers;

public class GameHandler {

    private boolean running = false;
    private Thread gameLoop;

    public GameHandler(){

    }

    public void start(GameView v) {
        final GameView view = v;
        this.running = true;
        gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    view.postInvalidate();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        gameLoop.start();
    }

}
