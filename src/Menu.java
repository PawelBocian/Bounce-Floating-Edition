import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends MouseAdapter {


    private Game game;
    private Handler handler;
    private ArrayList<Score> scoreBoard = new ArrayList<Score>();

    public Menu(Game game,Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    //Menu work controll function
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == GameState.MENU) {

            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-425,200,40)) {
                game.gameState = GameState.GAME;
                handler.changeLevel();
            }
            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-377,200,40)) {
                load_scores();
                game.gameState = GameState.SCORES;
            }
            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-327,200,40)) {
                game.gameState = GameState.HELP;
            }
            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-277,200,40)) {
                System.exit(1);
            }
        }
        if (game.gameState == GameState.HELP) {
            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-150,200,40)) {
                game.gameState = GameState.MENU;
            }

        }
        if (game.gameState == GameState.SCORES) {
            if (mouseOver(mx,my,game.gameValues.getWidth()/2 - 107,game.gameValues.getHeight()-150,200,40)) {
                game.gameState = GameState.MENU;
            }

        }
    }

    public void mouseReleased(MouseEvent e) {}

    // Checking if mouse is inside rectangle
    private boolean mouseOver(int mx,int my,int x,int y,int width,int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

    public void tick() {}

    //Render whole menu
    public void render(Graphics g) {

        Font buttons = new Font("arial",1,20);
        Font text = new Font("arial",1,12);
        g.setFont(buttons);
        g.setColor(Color.WHITE);

        if (game.gameState == GameState.MENU) {

            g.drawImage(game.images.background_image[0],0,0,game);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 425,200,40);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 377,200,40);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 327,200,40);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 277,200,40);

            // Setting all inscriptiona at the center of the screen
            g.drawString("New Game",game.gameValues.getWidth() / 2 - 55,game.gameValues.getHeight() - 400);
            g.drawString("Scores",game.gameValues.getWidth() / 2 - 39,game.gameValues.getHeight() - 350);
            g.drawString("Help",game.gameValues.getWidth() / 2 - 29,game.gameValues.getHeight() - 300);
            g.drawString("Exit",game.gameValues.getWidth() / 2 - 25,game.gameValues.getHeight() - 250);

        }
        if (game.gameState == GameState.HELP) {

            g.drawImage(game.images.background_image[1],0,0,game);
            g.setFont(text);
            g.drawRect(game.gameValues.getWidth() / 2 - 182,game.gameValues.getHeight() - 425,350,200);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 150,200,40);
            int x = game.gameValues.getWidth() / 2 - 161;
            int y = game.gameValues.getHeight() - 400;
            g.drawString("Enjoy floating bounce game edition     ",x,y);
            g.drawString("Put the ball into portal using keys W A S D ",x,20 + y);
            g.drawString("Do it as fast as possible but remember you ",x,40 + y);
            g.drawString("have to pay attention to obstacles and bonuses.",x,60 + y);
            g.drawString("Every coin gives you extra 30 points. Medkit adds",x,80 + y);
            g.drawString("one more life. Obstacle contact resets level ",x,100 + y);
            g.drawString("You can also press SPACE BAR to pause the game ",x,120 + y);
            g.drawString("Enjoy and Good Luck! ",x,140 + y);
            g.setFont(buttons);
            g.drawString("Return",game.gameValues.getWidth() / 2 - 39,game.gameValues.getHeight() - 123);


        }
        if (game.gameState == GameState.SCORES) {

            g.drawImage(game.images.background_image[2],0,0,game);
            g.drawRect(game.gameValues.getWidth() / 2 - 107,game.gameValues.getHeight() - 150,200,40);
            g.drawRect(game.gameValues.getWidth() / 2 - 83,game.gameValues.getHeight() - 420,150,180);
            g.setFont(buttons);
            g.drawString("Return",game.gameValues.getWidth() / 2 - 39,game.gameValues.getHeight() - 123);
            g.setFont(text);
            g.drawString("Nickname :     Score :",game.gameValues.getWidth() / 2 - 68,game.gameValues.getHeight()-400);
            for (int i = 0; i < 7 ; i++) {
                String record = scoreBoard.get(i).print_score();
                g.drawString(i+1+"."+record,game.gameValues.getWidth() / 2 -68,-380 + game.gameValues.getHeight() + 20 * i);
            }
        }
    }

    // Loading data from Scores.txt
    public void load_scores() {

        try {
            File file = new File("res/DataFiles/Scores.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                int points = Integer.parseInt(scan.nextLine());
                Score record = new Score(points,name);
                scoreBoard.add(record);
                System.out.println("Done");
            }
            ScoreComparator scoreComparator = new ScoreComparator();
            //Instant sorting by points
            scoreBoard.sort(scoreComparator);


        } catch (FileNotFoundException a) {
            System.out.println("Error");
        }
    }
}

