package chapter07.readFiveTimes;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Practice7_9_R5 {
    public static void main(String[] args) {
        Frame f = new Frame();
        // 익명 클래스(anonymous class)
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
    }
}
