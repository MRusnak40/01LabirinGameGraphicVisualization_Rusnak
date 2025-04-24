package MainLoop;

public class GameLoop implements Runnable {

    private MyFrame frame;
    public boolean running;









    public GameLoop(MyFrame frame) {
        this.frame = frame;
        this.running = true;
    }









//BY CHATGPT

    @Override
    public void run() {

        while (running) {
// Update game state
            frame.update();




            // Render the game
            frame.repaint();

            //if player touched enemy
            if(frame.gameOver){
                running = false;
            }

            // Sleep for a short duration to control the loop speed
            try {
                Thread.sleep(16); // Roughly 60 FPS
                //System.out.println(System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println(Thread.currentThread().getName());
        }
    }

//  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑  ↑





public void RestartGame() {


}













    public void stop() {
        running = false;
    }
}
