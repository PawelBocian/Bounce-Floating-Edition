public class GameValues {

    public int level; // current game level
    public long points; // player points
    public float health; // number of player lives
    private int windowWidth; // current GameWindow width
    private int windowHeight; // current GameWindow height

    public GameValues(int width,int height)
    {
        // Setting start vales
        level = 1;
        points =9999;
        health = 3;
        windowWidth = width;
        windowHeight = height;
    }

    //Reset values to basic
    public void reset(){
        this.level=1;
        this.points=9999;
        this.health=3;
    }

    // Getters

    public int getWidth(){
        return this.windowWidth;
    }

    public int getHeight(){
        return this.windowHeight;
    }

    // Setters

    public void setWidth(int width){
        this.windowWidth = width;
    }

    public void setHeight(int height){
        this.windowHeight = height;
    }

}

