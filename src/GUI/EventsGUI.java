package GUI;

import javax.swing.*;
import java.awt.*;

public class EventsGUI {
    public EventsGUI(){
        JFrame f = new JFrame("School Management System");
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0,0,1400,790);



        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);
        f.setBounds(300,100,1336,814);
        f.setVisible( true );
        f.setLayout(null);
        f.setResizable(false);


    }
}
