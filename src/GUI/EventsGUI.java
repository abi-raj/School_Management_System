package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class EventsGUI extends JFrame{
    public EventsGUI(){
        setTitle("School Management System");
       // JFrame f = new JFrame("School Management System");
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0,0,1400,790);



        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(p);
        p.setLayout(null);
        setBounds(300,100,1336,814);
        setVisible( true );
        setLayout(null);
        setResizable(false);


    }
}
