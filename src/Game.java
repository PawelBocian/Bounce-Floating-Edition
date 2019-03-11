import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    //Whole game elements

    protected int windowWidth = 920;
    protected int windowHeight = 643;
    public boolean working = false;
    private Handler handler;
    static GameGraphics images;
    private Menu menu;
    protected GameState gameState = GameState.MENU;
    protected GameValues gameValues;
    protected GameWindow main_window;
    private Thread thread;


    public Game() {

        handler = new Handler(this);
        menu = new Menu(this,handler);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        gameValues = new GameValues(windowWidth,windowHeight);
        images = new GameGraphics(windowWidth,windowHeight);
        main_window = new GameWindow(windowWidth,windowHeight,"Floating Ball",this);
    }

    public synchronized void start() {
        working = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        try {
            thread.join();
            working = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (working) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " Ticks: " + updates + " Lives :" + gameValues.health + " Points : " + gameValues.points);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
        if(gameState== gameState.MENU){
            menu.tick();
        }
    }

    //Creating BufferStrategy to render Graphics
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics gameph;
        gameph = bs.getDrawGraphics();

        handler.render(gameph);
        if(gameState == gameState.MENU || gameState == gameState.HELP || gameState == gameState.SCORES){ menu.render(gameph); }
        gameph.dispose();
        bs.show();
    }

    public static GameGraphics loadGraphics() {
        return images;
    }

    //Creating game
    public static void main(String args[]) {
        new Game();
    }
}