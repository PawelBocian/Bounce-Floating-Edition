import java.awt.*;
import java.util.LinkedList;

public class Medkit extends GameObject {

    public Medkit(int x,int y,ID id,Game game) {
        super(x,y,id,game);
    }

    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);
    }

    // Necessary to collision event
    public Rectangle getBounds(){
        return new Rectangle(pos_x,pos_y,this.scale_Width(84),this.scale_Height(84));
    }

    //Render Medkit Graphics
    public void render(Graphics g) {
        g.drawImage(GameGraphics.bonus_image[0],pos_x,pos_y,this.scale_Width(84),this.scale_Height(84),null);
    }
}