import java.awt.*;

public class Animation {

    private int speed;
    private int frames;

    private int index = 0;
    private int count = 0;

    private Image[] images;
    private Image currentImage;

    public Animation(int speed,Image... args) {
        this.speed = speed;
        images = new Image[args.length];
        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;
    }

    public void runAnimation() {
        index++;
        if (index > speed) {
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame() {
        for (int i = 0; i < frames; i++) {
            if (count == i)
                currentImage = images[i];
        }
        count++;

        if (count > frames)
            count = 0;
    }

    public void drawAnimation(Graphics g,int x,int y,int scaleX,int scaleY) {
        g.drawImage(currentImage,x,y,scaleX,scaleY,null);
    }
}
