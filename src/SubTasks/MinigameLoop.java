package SubTasks;

public class MinigameLoop implements Runnable {
    private boolean running = true;

    MinigameFrame frame = new MinigameFrame();


    @Override
    public void run() {
        while (running) {

            frame.repaint();
            frame.update();


            // Sleep for a short duration to control the loop speed
            try {
                Thread.sleep(16); // Roughly 60 FPS
                //System.out.println(System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
