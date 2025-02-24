package chapter07.readSixTimes;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Anonymous class - 익명 클래스
 */
public class Practice7_9_Anonymous_R6 {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    e.getWindow().setVisible(false);
                                    e.getWindow().dispose();
                                    System.exit(0);
                                }
                            }
        );
    }
}