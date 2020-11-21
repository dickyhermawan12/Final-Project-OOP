import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameInterface implements Runnable {
  private JFrame pongFrame;
  private Arena arena;

  public GameInterface() {
    this.arena = new Arena();
  }

  @Override
  public void run() {
    pongFrame = new JFrame("Pong");

    // fullscreen
    pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // bentuk semua komponen
    createComponents(pongFrame.getContentPane());

    // rekondisi ukuran komponen
    pongFrame.pack();

    // tampilkan frame
    pongFrame.setVisible(true);
  }

  private void createComponents(Container container) {
    pongFrame.add(this.arena);
    // listener untuk keyboard
    pongFrame.addKeyListener(new KeyboardListener(this.arena));
  }

  public JFrame getFrame() {
    return pongFrame;
  }

}