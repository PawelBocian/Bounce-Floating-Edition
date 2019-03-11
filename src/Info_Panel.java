import java.awt.*;
import java.util.LinkedList;

public class Info_Panel extends GameObject {

    public Info_Panel(int x, int y, ID id, Game game) {

        super(x,y,id,game);
    }


    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);
    }

    //unnecessary in this case
    public Rectangle getBounds() {
        return null;
    }

    //Render panel view
    public void render(Graphics g) {

        Font info_font = new Font("arial",1,20);
        g.setFont(info_font);
        g.setColor(Color.WHITE);
        g.drawString("Points : " + game.gameValues.points,4 * pos_x,pos_y);
        g.drawString("Level : " + game.gameValues.level,30 * pos_x,pos_y);
        if (game.gameValues.health < 2) {
            g.setColor(Color.RED);
            g.drawString("Lives : " + game.gameValues.health,19 * pos_x,pos_y);
        }else
            g.drawString("Lives : " + game.gameValues.health,19 * pos_x,pos_y);
    }
}


