import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    // Action when key is pressed
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int  i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player){

                // Changing player acceleration when pressing W,A,S,D or UP,DOWN,RIGHT,LEFT button
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP ) tempObject.setAccelerationY((float)-0.30);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setAccelerationY((float)0.25);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setAccelerationX((float)0.10);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setAccelerationX((float)-0.10);
                if (key == KeyEvent.VK_SPACE) // Pause game at SPACE
                {
                    if(handler.getPause()==false) {
                        handler.setPause(true);
                        return;
                    }
                    if(handler.getPause()==true) {
                        handler.setPause(false);
                        return;
                    }
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE) // Exit
            System.exit(1);
    }

    // Action when key is released
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int  i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player){

                // Setting acceleration at 0 when releasing. Cutting off power :P
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP ) tempObject.setAccelerationY(0);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setAccelerationY(0);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setAccelerationX(0);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setAccelerationX(0);
            }
        }
    }
}

