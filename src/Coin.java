import java.awt.*;
import java.util.LinkedList;

public class Coin extends GameObject {

    public Coin(int x,int y,ID id,Game game) {

        super(x,y,id,game);
    }

    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);
    }

    // Necessary to collision event
    public Rectangle getBounds(){
        return new Rectangle(pos_x,pos_y,scale_Width(32),scale_Height(32));
    }

    //Render Coin Graphics
    public void render(Graphics g) {
        g.drawImage(GameGraphics.bonus_image[1],pos_x,pos_y,scale_Width(32),scale_Height(32),null);
    }
}


