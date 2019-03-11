import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

//Class handles all GameObject

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();
    protected Game game;
    private boolean pause;

    public Handler(Game game) {
        this.game = game;
        pause = false;
    }

    public void tick() {

        for (int i = 0; i < object.size(); i++) {

            GameObject temporary = object.get(i);
            temporary.tick(object);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,game.gameValues.getWidth(),game.gameValues.getHeight());
        for (int i = 0; i < object.size(); i++) {

            GameObject temporary = object.get(i);
            temporary.render(g);
        }
    }
    //Add new object
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    //Remove object
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    //Remove all object
    public void clearLevel() {
        object.clear();
    }

    //Loading level (number of all objects and their coordinates)
    public void loadLevel(String path) {

        try {
            System.out.println(path);
            File file = new File(path);
            Scanner odczyt = new Scanner(file);
            while (odczyt.hasNextLine()) {
                if (odczyt.nextLine().equals("obstacle0")) {
                    int m = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < m; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle0,game));
                    }
                }
               if (odczyt.nextLine().equals("obstacle1")) {
                    int m = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < m; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()) ,ID.Obstacle1,game));
                    }
                }
                if (odczyt.nextLine().equals("obstacle2")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle2,game));
                    }
                }
                if (odczyt.nextLine().equals("obstacle3")) {
                    int o = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < o; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle3,game));
                    }
                }
                if (odczyt.nextLine().equals("obstacle4")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle4,game));
                    }
                }
                if (odczyt.nextLine().equals("obstacle6")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle6,game));
                    }
                }
                if (odczyt.nextLine().equals("obstacle7")) {
                    int m = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < m; z++) {
                        this.addObject(new Obstacle(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Obstacle7,game));
                    }
                }
                if (odczyt.nextLine().equals("portal")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Portal(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Portal,game));
                    }
                }
                if (odczyt.nextLine().equals("player")) {
                    int p = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < p; z++) {
                        this.addObject(new Player(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),this,ID.Player,Float.parseFloat(odczyt.nextLine()),game));
                    }
                }
                if (odczyt.nextLine().equals("coin")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Coin(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Coin,game));
                    }
                }
                if (odczyt.nextLine().equals("medicine_kit")) {
                    int r = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < r; z++) {
                        this.addObject(new Medkit(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.MedKit,game));
                    }
                }
                if (odczyt.nextLine().equals("info_bar")) {
                    int we = Integer.parseInt(odczyt.nextLine());
                    for (int z = 0; z < we; z++) {
                        this.addObject(new Info_Panel(Integer.parseInt(odczyt.nextLine()),Integer.parseInt(odczyt.nextLine()),ID.Info_Panel,game));
                     }
                }
            }
        } catch (FileNotFoundException a) {
            System.out.println("Error");
        }
    }

    //Update game level
    public void changeLevel() {
        clearLevel();
        if (game.gameValues.health > 0) {
            switch (game.gameValues.level) {
                case 1:
                    loadLevel("res/Levels/Level1.txt");
                    break;
                case 2:
                    loadLevel("res/Levels/Level2.txt");
                    break;
                case 3:
                    loadLevel("res/Levels/Level3.txt");
                    break;
                case 4:                                         // In case you want add another level just make new case and load level like above
                    game.gameState = GameState.MENU;
                    String nickname = "";
                    while (nickname.length() == 0) {
                        nickname = JOptionPane.showInputDialog(game.main_window.window,"Enter Nickname: ","Congrats ! Game finished ",JOptionPane.QUESTION_MESSAGE);
                        if (nickname == null)
                            break;
                        //Saving score to Score.txt file
                        SaveScore(nickname,game.gameValues);
                    }
                    game.gameValues.reset();
            }
        } else {
            game.gameState = GameState.MENU;
            String nickname = "";
            while (nickname.length() == 0) {
                nickname = JOptionPane.showInputDialog(game.main_window.window,"Enter Nickname: ","Congrats ! Game finished ",JOptionPane.QUESTION_MESSAGE);
                if (nickname == null)
                    break;
                //Saving score to Score.txt file
                SaveScore(nickname,game.gameValues);
            }
            game.gameValues.reset();
        }
    }
    //Set pause when spacebar pressed
    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean getPause() {

        return pause;
    }

    //Save score to Score.txt file
    public static void SaveScore(String imie,GameValues gamevalues)  {
        try {
            FileWriter write = new FileWriter("res/DataFiles/Scores.txt",true);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(imie);
            writer.newLine();
            writer.write(Long.toString(gamevalues.points));
            writer.newLine();
            writer.close();

            }
        catch (IOException ex) {}
    }
}









