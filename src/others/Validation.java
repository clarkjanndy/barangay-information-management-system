package others;

import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Validation {

    String y = "0";

    public void isDigit(final JTextField tf) {
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9') || e.getKeyChar() == '.')) {
                    e.consume();

                }
            }
        });
    }

    public void isLetter(final JTextArea tf) {
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9'))) {
                    e.consume();
                }
            }
        });

    }

    public void isLetter(final JTextField tf) {
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9'))) {
                    e.consume();
                }
            }
        });

    }
}
