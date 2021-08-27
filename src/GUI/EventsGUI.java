package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class EventsGUI extends JFrame{
    public EventsGUI(){
        setTitle("School Management System");
       // JFrame f = new JFrame("School Management System");
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0,0,1000,800);

        JLabel event_info=new JLabel("UPCOMING EVENTS");
        event_info.setBounds(50,50,300,60);
        event_info.setForeground(Color.black);
        event_info.setFont(new Font("Segeo UI",Font.BOLD,24));
        p.add(event_info);

        JLabel event_poster=new JLabel();
        event_poster.setBounds(50,130,900,150);
        event_poster.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("images/poster.png")))));
        p.add(event_poster);

        JLabel exam_schedule_info=new JLabel("EXAM SCHEDULE");
        exam_schedule_info.setBounds(50,350,300,60);
        exam_schedule_info.setForeground(Color.black);
        exam_schedule_info.setFont(new Font("Segeo UI",Font.BOLD,24));
        p.add(exam_schedule_info);

        String data[][]= {{"Quarterly Exam", "27/08/2021", "02/09/2021"},
        };
        String column[]={"EXAM TITLE","START DATE","END DATE"};
        JTable jt=new JTable(data,column);
        jt.setModel(new DefaultTableModel(
                new Object[][] {
                        {"EXAM TITLE","START DATE","END DATE"},
                        {"Quarterly Exam", "27/08/2021", "02/09/2021"},
                        {null, null, null},


                },
                new String[] {
                        "EXAM TITLE","START DATE","END DATE"
                }
        ));
        jt.setRowHeight(jt.getRowHeight() + 40);
        jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jt.setBounds(50,420,800,170);
        p.add(jt);

        JLabel contact_lbl=new JLabel("For more information, contact the school directly.Thank You.......");
        contact_lbl.setBounds(50,650,550,60);
        contact_lbl.setForeground(Color.black);
        contact_lbl.setFont(new Font("Segeo UI",Font.BOLD,18));
        p.add(contact_lbl);


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(p);
        p.setLayout(null);
        setBounds(300,100,1000,800);
        setVisible( true );
        setLayout(null);
        setResizable(false);


    }
}
