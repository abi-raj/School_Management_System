package GUI.admin;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {

    public AdminGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 720);
        setVisible(true);
        setResizable(false);
        sidebarComponent();
    }

    public static void main(String[] args) {
        new AdminGUI();
    }

    void sidebarComponent(){
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        contentPane.add(p);
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(237, 71, 174));
        sidebar.setBounds(0, 0, 120, 814);
        p.add(sidebar);
        sidebar.setLayout(null);
    }

}
