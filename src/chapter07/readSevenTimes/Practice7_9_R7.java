package chapter07.readSevenTimes;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Practice7_9_R7 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.addWindowListener(new EventHandler());
    }
}

class EventHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
}