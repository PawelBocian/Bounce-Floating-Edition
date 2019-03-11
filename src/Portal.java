import java.awt.*;
import java.util.LinkedList;

public class Portal extends GameObject {

    private Animation spin;

    public Portal(int x, int y, ID id, Game game) {

        super(x,y,id,game);
        spin = new Animation(7,GameGraphics.portal_image[0],GameGraphics.portal_image[1],GameGraphics.portal_image[2],GameGraphics.portal_image[3],GameGraphics.portal_image[4],GameGraphics.portal_image[5],GameGraphics.portal_image[6],GameGraphics.portal_image[7],GameGraphics.portal_image[8]);
    }

    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);
        spin.runAnimation();
    }

    // Necessary to collision event
    public Rectangle getBounds(){
            return new Rectangle(pos_x+16,pos_y+16,48,48);
        }

    //Render Portal Graphics
    public void render(Graphics g) {
        spin.drawAnimation(g,pos_x,pos_y,scale_Width(80),scale_Height(80));
    }
}
