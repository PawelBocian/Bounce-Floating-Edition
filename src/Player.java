import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class Player extends GameObject {

    public float gamevity;
    private final float MAX_SPEED = 10;
    public int tempWidth;
    public int tempHeight;
    Ellipse2D Eclipse;
    private Handler handler;

    public Player(int x, int y, Handler handler, ID id, float gamevity, Game game) {
        super(x,y,id,game);
        this.handler = handler;
        this.gamevity = gamevity;
        tempHeight = game.windowHeight;
        tempWidth = game.windowWidth;

    }

    public void tick(LinkedList<GameObject> object) {
        pos_x = scale_X(pos_x);
        pos_y = scale_Y(pos_y);

        Eclipse = new Ellipse2D.Float(pos_x,pos_y,(float)48*game.gameValues.getWidth()/game.windowWidth,(float)48*game.gameValues.getHeight()/game.windowHeight);

        // Controlling player
        if(handler.getPause() == false && falling) {
            pos_y += velocity_y;
            pos_x += velocity_x;
            game.gameValues.points--;
            velocity_y += gamevity + acceleration_Y;
            velocity_x += acceleration_X;
                if(velocity_x != 0)
                    if(velocity_x > 0)
                    velocity_x = velocity_x -(float)0.02;
                    else
                    velocity_x = velocity_x +(float)0.02;
                if(velocity_y > MAX_SPEED)
                    velocity_y = MAX_SPEED;
        }
        collision(object);
    }

    public Rectangle getBounds(){
        return null;
    }

    //Collision listener
    private void collision(LinkedList<GameObject> object) {

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Obstacle0 || tempObject.getId() == ID.Obstacle1 || tempObject.getId() == ID.Obstacle2 || tempObject.getId() == ID.Obstacle3 || tempObject.getId() == ID.Obstacle4|| tempObject.getId() == ID.Obstacle5 || tempObject.getId() == ID.Obstacle6 || tempObject.getId() == ID.Obstacle7) {
                if (Eclipse.intersects(tempObject.getBounds())) {
                    velocity_x=0;
                    velocity_y=0;
                    handler.game.gameValues.health--;
                    handler.changeLevel();
                }
            }
            if (tempObject.getId() == ID.Portal) {
                if (Eclipse.intersects(tempObject.getBounds())) {
                    handler.game.gameValues.level++;
                    handler.changeLevel();
                }
            }
            if (tempObject.getId() == ID.MedKit) {
                if (Eclipse.intersects(tempObject.getBounds())) {
                    handler.game.gameValues.health++;
                    handler.removeObject(tempObject);
                }
            }
            if (tempObject.getId() == ID.Coin) {
                if (Eclipse.intersects(tempObject.getBounds())) {
                    handler.game.gameValues.points = handler.game.gameValues.points + 20 ;
                    handler.removeObject(tempObject);
                }
            }
        }
    }

    //Render Player Graphics
    public void render(Graphics g) {
        g.drawImage(GameGraphics.player_image[0],pos_x,pos_y,this.scale_Width(48),this.scale_Height(48),null);
    }
}
