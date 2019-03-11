import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameWindow extends  Canvas{

JFrame window;

public GameWindow(int width,int height ,String title,Game game) {

    window = new JFrame(title);
    window.setPreferredSize(new Dimension(width,height));
    window.setMaximumSize(new Dimension(width,height));
    window.setMinimumSize(new Dimension(width,height));
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.add(game);
    window.setVisible(true);

    game.images.update_images(game.gameValues.getWidth(),game.gameValues.getHeight());
    // Frame/Window size listener

    window.getContentPane().addComponentListener(new ComponentAdapter() {
        public void componentResized(ComponentEvent e) {

            //If changed - update width and height in storage GameValues
            game.gameValues.setWidth(window.getWidth());
            game.gameValues.setHeight(window.getHeight());

            //If changed - resize images (In this case only menu backgrounds )
            game.images.update_images(window.getWidth(),window.getHeight());
        }
    });

    //Start game
    game.start();
}
}

