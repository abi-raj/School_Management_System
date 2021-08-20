/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 * @author Grace
 */
public class LoginGUI  {


    private JLabel img;
    private JLabel l1;
    private JLabel l2;
    private JLabel l_email;
    private JLabel l_pwd;
    private JPanel p;
    private JPasswordField t_pwd;
    private JTextField t_email;
    private JButton b;



    public LoginGUI() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JFrame f = new JFrame("School Management System");
        p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0,0,1400,790);

        img = new JLabel();
        l1 = new JLabel();
        l2 = new JLabel();
        l_email = new JLabel();
        t_email = new JTextField();
        l_pwd = new JLabel();
        t_pwd = new JPasswordField();
        b = new JButton();

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);


        img.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/login bg.png"))));
        img.setBounds(0,0,727,720);
        img.setVisible(true);
        p.add(img);

        l1.setText("Welcome to School");
        l1.setFont(new Font("Segoe UI",Font.BOLD, 36));
        l1.setForeground(new Color(102, 102, 102));
        l1.setBounds(770,150,400,40);
        l1.setVisible(true);
        f.add(l1);
        p.add(l1);

        l2.setText("Log in to your account");
        l2.setFont(new Font("Segoe UI",Font.PLAIN, 18));
        l2.setForeground(new Color(102, 102, 102));
        l2.setBounds(770,200,400,50);
        l2.setVisible(true);
        f.add(l2);
        p.add(l2);

        l_email.setText("Email Address");
        l_email.setFont(new Font("Segoe UI",Font.BOLD, 18));
        l_email.setForeground(new Color(102, 102, 102));
        l_email.setBounds(770,280,400,50);
        l_email.setVisible(true);
        p.add(l_email);



        t_email.setFont(new Font("Segoe UI",Font.PLAIN, 16));
        t_email.setMargin(new Insets(5, 10, 5, 5));
        t_email.setBounds(770,330,400,50);
        t_email.setVisible(true);
        p.add(t_email);


        l_pwd.setText("Password");
        l_pwd.setFont(new Font("Segoe UI",Font.BOLD, 18));
        l_pwd.setForeground(new Color(102, 102, 102));
        l_pwd.setBounds(770,380,400,50);
        l_pwd.setVisible(true);
        p.add(l_pwd);


        t_pwd.setFont(new Font("Segoe UI",Font.PLAIN, 16));
        t_pwd.setMargin(new Insets(5, 10, 5, 5));
        t_pwd.setBounds(770,430,400,50);
        t_pwd.setVisible(true);
        p.add(t_pwd);

        b.setText("Login");
        b.setBackground(new Color(32, 83, 116));
        b.setFont(new Font("Segoe UI",Font.BOLD, 18));
        b.setForeground(new Color(255, 255, 255));
        b.setBounds(770,530,400,50);
        b.setVisible(true);
        b.setLayout(null);
        b.setFocusPainted(false);
        b.setBorder(null);
        p.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TeacherGUI();
                f.dispose();
            }
        });


        f.setBounds(300,100,1260,790);
        f.setVisible( true );
        f.setLayout(null);
        f.setResizable(false);

    }




}
