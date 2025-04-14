package MainLoop;

public class GameLoop implements Runnable {

    private MyFrame frame;
    private boolean running;









    public GameLoop(MyFrame frame) {
        this.frame = frame;
        this.running = true;
    }









//BY CHATGPT

    @Override
    public void run() {

        while (running) {
            frame.update(); // Update game state
            frame.repaint(); // Render the game

            // Sleep for a short duration to control the loop speed
            try {
                Thread.sleep(16); // Roughly 60 FPS
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

//  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑



















    public void stop() {
        running = false;
    }
}
