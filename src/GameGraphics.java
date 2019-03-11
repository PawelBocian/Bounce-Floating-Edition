import org.ini4j.Wini;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGraphics {

        // Extra variables to scale
        int windowWidth;
        int windowHeight;

        // Extra variables to contain Graphics load from ConfigFile
        private BufferedImage image;
        private BufferedImage player = null;
        private BufferedImage obstacle0 = null;
        private BufferedImage obstacle1 = null;
        private BufferedImage obstacle2= null;
        private BufferedImage obstacle3 = null;
        private BufferedImage obstacle4= null;
        private BufferedImage obstacle5 = null;
        private BufferedImage obstacle6 = null;
        private BufferedImage obstacle7 = null;
        private BufferedImage portal10 = null;
        private BufferedImage portal20 = null;
        private BufferedImage portal30 = null;
        private BufferedImage portal40 = null;
        private BufferedImage portal50 = null;
        private BufferedImage portal60 = null;
        private BufferedImage portal70 = null;
        private BufferedImage portal80 = null;
        private BufferedImage portal90 = null;
        private BufferedImage bonus1 = null;
        private BufferedImage bonus2 = null;
        private BufferedImage background_menu = null;
        private BufferedImage background_help = null;
        private BufferedImage background_scores = null;

        // Arrays contains correct Object images

        public Image[] portal_image = new Image[9];
        public Image[] player_image = new Image[1];
        public Image[] obstacle_image = new Image[8];
        public Image[] bonus_image = new Image[2];
        public Image[] background_image = new Image[3];


        public GameGraphics(int width,int height){
            this.windowWidth = width;
            this.windowHeight = height;

            try{

                // Loading images from ress/Graphics by name included in config.ini file

                try{
                    Wini ini = new Wini(new File("res/DataFiles/Config.ini"));


                obstacle0 = loadImage(ini.get("obstacles","horizontal_obs")); // horizontal obstacle - Obstacle0
                obstacle1 = loadImage(ini.get("obstacles","vertical_obs")); // vertical obstacle - Obstacle1
                obstacle2 = loadImage(ini.get("obstacles","right_down_obs")); // right-down corner connection - Obstacle2
                obstacle3 = loadImage(ini.get("obstacles","right_up_obs")); // right-up corner connection - Obstacle3
                obstacle4 = loadImage(ini.get("obstacles","left_down_obs")); // left-down corner connection - Obstacle4
                obstacle5 = loadImage(ini.get("obstacles","horizontal_up_obs")); // horizontal - up connection - Obstacle5
                obstacle6 = loadImage(ini.get("obstacles","horizontal_down_obs")); // horizontal - down connection - Obstacle6
                obstacle7 = loadImage(ini.get("obstacles","left_up_obs")); // left-up corner connection - Obstacle7


                portal10 = loadImage(ini.get("portal","portal0")); //portal10.png
                portal20 = loadImage(ini.get("portal","portal1")); //portal20.png
                portal30 = loadImage(ini.get("portal","portal2")); //portal30.png
                portal40 = loadImage(ini.get("portal","portal3")); //portal40.png
                portal50 = loadImage(ini.get("portal","portal4")); //portal50.png
                portal60 = loadImage(ini.get("portal","portal5")); //portal60.png
                portal70 = loadImage(ini.get("portal","portal6")); //portal70.png
                portal80 = loadImage(ini.get("portal","portal7")); //portal80.png
                portal90 = loadImage(ini.get("portal","portal8")); //portal90.png

                player = loadImage(ini.get("player","player")); // player Graphics - Player.png

                bonus1 = loadImage(ini.get("bonus","medkit")); // medkit Graphics - Coin.png
                bonus2 = loadImage(ini.get("bonus","coin")); // coin Graphics - MedKit.png

                background_menu = loadImage(ini.get("backgrounds","menu"));//menu basic background - background_menu.png
                background_help = loadImage(ini.get("backgrounds","help"));//menu help background - background_help.png
                background_scores = loadImage(ini.get("backgrounds","scores"));//menu scores background - background_scores.png

                }catch(Exception e){
                    System.err.println(e.getMessage());
                }

            }catch(Exception e){
                e.printStackTrace();
            }
            update_images(windowWidth,windowHeight);
        }

        //Loader image from patch
        public BufferedImage loadImage(String path){
            try {
                image = ImageIO.read(getClass().getResource(path));
            }catch (IOException e){
            e.printStackTrace();
            }
        return image;
        }

        public void update_images(int width,int height){

            // Adding images into special Arrays (first instant scale some of them)
            obstacle_image[0] = obstacle0;
            obstacle_image[1] = obstacle1;
            obstacle_image[2] = obstacle2;
            obstacle_image[3] = obstacle3;
            obstacle_image[4] = obstacle4;
            obstacle_image[5] = obstacle5;
            obstacle_image[6] = obstacle6;
            obstacle_image[7] = obstacle7;

            portal_image[0] = portal10.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[1] = portal20.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[2] = portal30.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[3] = portal40.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[4] = portal50.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[5] = portal60.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[6] = portal70.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[7] = portal80.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            portal_image[8] = portal90.getScaledInstance(80,80,Image.SCALE_DEFAULT);

            player_image[0] = player.getScaledInstance(48,48,Image.SCALE_DEFAULT);
            bonus_image[0] = bonus1.getScaledInstance(84,84,Image.SCALE_DEFAULT);
            bonus_image[1] = bonus2.getScaledInstance(32,32,Image.SCALE_DEFAULT);

            background_image[0] = background_menu.getScaledInstance(width,height,Image.SCALE_DEFAULT);
            background_image[1] = background_help.getScaledInstance(width,height,Image.SCALE_DEFAULT);
            background_image[2] = background_scores.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        }
    }
