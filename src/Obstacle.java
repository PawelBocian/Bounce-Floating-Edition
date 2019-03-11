import java.awt.*;
import java.util.LinkedList;

public class Obstacle extends GameObject {

    public Obstacle(int x,int y,ID id,Game game) {
        super(x,y,id,game);
    }

    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);
    }

    // Necessary to collision event
    public Rectangle getBounds() {
        return new Rectangle(pos_x,pos_y,scale_Width(32),scale_Height(32));
    }

    //Render obstacle Graphics depends on obstacle id
    public void render(Graphics g) {

        if (id == ID.Obstacle0) { // pozioma obstacle
            g.drawImage(GameGraphics.obstacle_image[0],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle1) { // pionowa obstacle
            g.drawImage(GameGraphics.obstacle_image[1],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle2) { // lacznik dol prawo
            g.drawImage(GameGraphics.obstacle_image[2],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle3) { // lacznik gora prawo
            g.drawImage(GameGraphics.obstacle_image[3],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle4) { // lacznik gora lewo
            g.drawImage(GameGraphics.obstacle_image[4],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle5) { // lacznik z gory w dol
            g.drawImage(GameGraphics.obstacle_image[5],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle6) { // lacznik z dolu w gore
            g.drawImage(GameGraphics.obstacle_image[6],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        } else if (id == ID.Obstacle7) { // lacznik gora lewo
            g.drawImage(GameGraphics.obstacle_image[7],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
        }
    }
}


