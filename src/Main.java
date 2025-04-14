import MainLoop.GameLoop;
import MainLoop.MyFrame;
import PreImplements.Frame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        GameLoop loop = new GameLoop(new MyFrame());
        Thread thread = new Thread(loop);
        thread.start();
        //  Frame frame = new Frame();


//do player dat  pohyb zvlast jak v enemy
        //ve frame dat runnable a pustit tam ten pohyb pro enemy kde bude mit cil se dostat na current x y hrace
        //INTERAKCE S DVERMA UDELAME JAKO COLISION DETECTION
    }
}