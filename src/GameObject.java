import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    protected Game game;
    public int pos_x,pos_y;
    protected ID id;
    public int tempWidth;
    public int tempHeight;
    private int scaled_width;
    private int scaled_height;
    protected boolean falling = true;
    protected float velocity_x = 0;
    protected float velocity_y = 0;
    protected float acceleration_X = 0;
    protected float acceleration_Y = 0;

    GameGraphics GameGraphics = game.loadGraphics();

    public GameObject(int x, int y, ID id, Game game) {
        this.pos_x = x;
        this.pos_y = y;
        this.id = id;
        this.game = game;
        tempHeight = game.windowHeight;
        tempWidth = game.windowWidth;
    }

    public abstract void tick(LinkedList<GameObject> object);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public ID getId() {
        return this.id;
    }
    public void setAccelerationX(float x) {
        this.acceleration_X = x;
    }

    public void setAccelerationY(float y) {
        this.acceleration_Y = y;
    }

    public int scale_X(int pos_x) {

        boolean scale = false;

            if(tempWidth != game.gameValues.getWidth())
            {
                scale = true;
                System.out.println("scale");
            }
            if(scale)
            {
                this.pos_x = pos_x*game.gameValues.getWidth()/tempWidth;
                tempWidth = game.gameValues.getWidth();
            }
        return this.pos_x;
    }

    public int scale_Y(int pos_y) {

        boolean scale = false;

            if(tempHeight != game.gameValues.getHeight())
            {
                scale = true;
                System.out.println("scale");
            }
            if(scale)
            {
                this.pos_y = pos_y*game.gameValues.getHeight()/tempHeight;
                tempHeight = game.gameValues.getHeight();
            }
        return this.pos_y;
    }

    public int scale_Width(int width){
        scaled_width = width*game.gameValues.getWidth()/game.windowWidth;
        return scaled_width;
    }

    public int scale_Height(int height){
        scaled_height = height*game.gameValues.getHeight()/game.windowHeight;
        return scaled_height;
    }
}
