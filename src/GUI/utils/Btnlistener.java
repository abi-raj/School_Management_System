package GUI.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Color;

public class Btnlistener extends MouseAdapter {
    JRadioButton btn;
    JTextField txt;

    public Btnlistener(JRadioButton btn, JTextField txt) {
        this.btn = btn;
        this.txt = txt;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (btn.getText().equals("Specific")) {
            txt.setEnabled(true);
            txt.setForeground(Color.BLACK);
            txt.setText("");
        } else {
            txt.setEnabled(false);
            txt.setForeground(Color.LIGHT_GRAY);
            if (!btn.isSelected()) {
                txt.setText(btn.getText());
            }
        }

    }

}
