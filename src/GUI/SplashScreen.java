package GUI;
import javax.swing.*;
import java.util.Objects;

public class SplashScreen {
    public SplashScreen(){
        JWindow f = new JWindow();
        JLabel splashicon=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Splashscreen.png"))));
        splashicon.setBounds(0,0,1200,800);
        f.add(splashicon);
                f.setBounds(300,100,1200,800);
                f.setLayout(null);
                f.setVisible(true);
        try {
            Thread.sleep(5000);
            f.dispose();
            new LoginGUI();
        } catch(Exception e) {
            e.printStackTrace();
        }
            }


    public static void main(String[]args) {
                SplashScreen ob = new SplashScreen();

            }
        }


