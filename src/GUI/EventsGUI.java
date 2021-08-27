package GUI;

import javax.swing.*;
import java.awt.*;

public class EventsGUI extends JFrame{
    public EventsGUI(){
        setTitle("School Management System");
       // JFrame f = new JFrame("School Management System");
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0,0,1400,790);

        JLabel event_info=new JLabel("   Upcoming events");
        event_info.setBounds(100,50,300,60);
        event_info.setForeground(Color.white);
        event_info.setBackground(new Color(242,106,109));
        event_info.setOpaque(true);
        event_info.setFont(new Font("Segeo UI",Font.BOLD,28));
        p.add(event_info);




        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(p);
        p.setLayout(null);
        setBounds(300,100,1336,814);
        setVisible( true );
        setLayout(null);
        setResizable(false);


    }
}
