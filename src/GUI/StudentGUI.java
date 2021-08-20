
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentGUI extends JFrame {

    JPanel panel_content;


    public static void main(String[] args) {

        new StudentGUI();

    }

    JPanel panel_profileWindow,panel_gradeWindow,panel_MaterialsWindow,panel_leaveFormWindow,panel_inquiryWindow,panel_feeWindow;
    private JLabel lbl_checkStatus,lbl_LfSubmit,lbl_Isubmit,lbl_checkResponse;
    private JLabel lbl_pay;
    private JTextField textField_amount;
    public StudentGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1237, 665);
        panel_content = new JPanel();
        panel_content.setBackground(Color.WHITE);
        panel_content.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel_content);
        panel_content.setLayout(null);

        JPanel panel_side = new JPanel();
        panel_side.setBackground(new Color(0, 0, 139));
        panel_side.setBounds(20, 0, 149, 617);
        panel_content.add(panel_side);
        panel_side.setLayout(null);


        JLabel lbl_profileIcon = new JLabel("");
        lbl_profileIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(true);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        });
        lbl_profileIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/profileIcon.png")));
        lbl_profileIcon.setBounds(44, 77, 48, 51);
        lbl_profileIcon.setToolTipText("Profile\r\n");
        panel_side.add(lbl_profileIcon);

        JLabel lbl_gradeIcon = new JLabel("");
        lbl_gradeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(true);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);
            }
        });
        lbl_gradeIcon.setToolTipText("Grades");
        lbl_gradeIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/gradeIcon.png")));
        lbl_profileIcon.setToolTipText("Profile");
        lbl_gradeIcon.setBounds(44, 162, 53, 51);
        panel_side.add(lbl_gradeIcon);

        JLabel lbl_materialsIcon = new JLabel("");
        lbl_materialsIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(true);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);
            }
        });
        lbl_materialsIcon.setToolTipText("Learning Materials");
        lbl_materialsIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/materialsIcon.png")));
        lbl_materialsIcon.setBounds(44, 251, 48, 51);
        panel_side.add(lbl_materialsIcon);

        JLabel lbl_leaveFormIcon = new JLabel("");
        lbl_leaveFormIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(true);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        });
        lbl_leaveFormIcon.setToolTipText("Leave Form");
        lbl_leaveFormIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/leaveFormIcon.png")));
        lbl_leaveFormIcon.setBounds(44, 340, 48, 51);
        panel_side.add(lbl_leaveFormIcon);

        JLabel lbl_InquiryIcon = new JLabel("");
        lbl_InquiryIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(true);
                panel_feeWindow.setVisible(false);
            }
        });
        lbl_InquiryIcon.setToolTipText("Inquiry");
        lbl_InquiryIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/inquiryIcon.png")));
        lbl_InquiryIcon.setBounds(44, 426, 48, 51);
        panel_side.add(lbl_InquiryIcon);

        JLabel lbl_feeIcon = new JLabel("");
        lbl_feeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(true);
            }
        });
        lbl_feeIcon.setToolTipText("Fee Payment");
        lbl_feeIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/feeIcon.png")));
        lbl_feeIcon.setBounds(44, 512, 48, 51);
        panel_side.add(lbl_feeIcon);

        panel_profileWindow = new JPanel();
        panel_profileWindow.setBackground(Color.WHITE);
        panel_profileWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_profileWindow);
        panel_profileWindow.setLayout(null);

        JPanel panel_name = new JPanel();
        panel_name.setBounds(241, 85, 339, 79);
        panel_profileWindow.add(panel_name);
        panel_name.setLayout(null);

        JLabel lbl_name1 = new JLabel("   Sample");
        lbl_name1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_name1.setBounds(0, 32, 339, 47);
        panel_name.add(lbl_name1);

        JLabel lbl_name = new JLabel(" Name");
        lbl_name.setBounds(0, 0, 339, 32);
        panel_name.add(lbl_name);
        lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JPanel panel_class = new JPanel();
        panel_class.setBounds(241, 200, 339, 79);
        panel_profileWindow.add(panel_class);
        panel_class.setLayout(null);

        JLabel lbl_class1 = new JLabel("   Sample");
        lbl_class1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_class1.setBounds(0, 32, 339, 47);
        panel_class.add(lbl_class1);

        JLabel lbl_class = new JLabel(" Class");
        lbl_class.setBounds(0, 0, 339, 32);
        panel_class.add(lbl_class);
        lbl_class.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JPanel panel_email = new JPanel();
        panel_email.setBounds(241, 313, 339, 79);
        panel_profileWindow.add(panel_email);
        panel_email.setLayout(null);

        JLabel lbl_email1 = new JLabel("   Sample");
        lbl_email1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_email1.setBounds(0, 32, 339, 47);
        panel_email.add(lbl_email1);

        JLabel lbl_email = new JLabel(" E-mail");
        lbl_email.setBounds(0, 0, 339, 32);
        panel_email.add(lbl_email);
        lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JPanel panel_dob = new JPanel();
        panel_dob.setBounds(241, 425, 339, 79);
        panel_profileWindow.add(panel_dob);
        panel_dob.setLayout(null);

        JLabel lbl_dob1 = new JLabel("   Sample");
        lbl_dob1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_dob1.setBounds(0, 32, 339, 47);
        panel_dob.add(lbl_dob1);

        JLabel lbl_dob = new JLabel(" Date of Birth");
        lbl_dob.setBounds(0, 0, 339, 32);
        panel_dob.add(lbl_dob);
        lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JPanel panel_cno = new JPanel();
        panel_cno.setBounds(241, 533, 339, 73);
        panel_profileWindow.add(panel_cno);
        panel_cno.setLayout(null);

        JLabel lbl_cno1 = new JLabel("   Sample");
        lbl_cno1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_cno1.setBounds(0, 26, 339, 47);
        panel_cno.add(lbl_cno1);

        JLabel lbl_cno = new JLabel(" Contact Number");
        lbl_cno.setBounds(0, 0, 339, 32);
        panel_cno.add(lbl_cno);
        lbl_cno.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lbl_welcome = new JLabel("Welcome Student!");
        lbl_welcome.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_welcome.setBounds(10, 11, 472, 63);
        panel_profileWindow.add(lbl_welcome);

        panel_gradeWindow = new JPanel();
        panel_gradeWindow.setBackground(Color.WHITE);
        panel_gradeWindow.setBounds(171, 0, 1052, 617);
        panel_content.add(panel_gradeWindow);
        panel_gradeWindow.setLayout(null);

        JLabel lbl_Grade = new JLabel("Grades");
        lbl_Grade.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_Grade.setBounds(22, 0, 311, 58);
        panel_gradeWindow.add(lbl_Grade);

        JPanel panel_Exam = new JPanel();
        panel_Exam.setBounds(176, 127, 254, 58);
        panel_gradeWindow.add(panel_Exam);
        panel_Exam.setLayout(null);

        JLabel lbl_Exam = new JLabel("Exam");
        lbl_Exam.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Exam.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_Exam.setBounds(0, 0, 254, 58);
        panel_Exam.add(lbl_Exam);

        JPanel panel_Grades = new JPanel();
        panel_Grades.setBounds(558, 127, 254, 58);
        panel_gradeWindow.add(panel_Grades);
        panel_Grades.setLayout(null);

        JLabel lbl_Grades = new JLabel("Grades");
        lbl_Grades.setBounds(0, 0, 254, 58);
        panel_Grades.add(lbl_Grades);
        lbl_Grades.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Grades.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lbl_Exam1 = new JLabel("Sample");
        lbl_Exam1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Exam1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Exam1.setBounds(176, 238, 254, 50);
        panel_gradeWindow.add(lbl_Exam1);

        JLabel lbl_Grade1 = new JLabel("Sample");
        lbl_Grade1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Grade1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Grade1.setBounds(558, 238, 254, 50);
        panel_gradeWindow.add(lbl_Grade1);

        JLabel lbl_Exam2 = new JLabel("Sample");
        lbl_Exam2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Exam2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Exam2.setBounds(176, 325, 254, 50);
        panel_gradeWindow.add(lbl_Exam2);

        JLabel lbl_Exam3 = new JLabel("Sample");
        lbl_Exam3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Exam3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Exam3.setBounds(176, 405, 254, 50);
        panel_gradeWindow.add(lbl_Exam3);

        JLabel lbl_Exam4 = new JLabel("Sample");
        lbl_Exam4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Exam4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Exam4.setBounds(176, 496, 254, 50);
        panel_gradeWindow.add(lbl_Exam4);

        JLabel lbl_Grade2 = new JLabel("Sample");
        lbl_Grade2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Grade2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Grade2.setBounds(558, 325, 254, 50);
        panel_gradeWindow.add(lbl_Grade2);

        JLabel lbl_Grade3 = new JLabel("Sample");
        lbl_Grade3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Grade3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Grade3.setBounds(558, 405, 254, 50);
        panel_gradeWindow.add(lbl_Grade3);

        JLabel lbl_Grade4 = new JLabel("Sample");
        lbl_Grade4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Grade4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_Grade4.setBounds(558, 496, 254, 50);
        panel_gradeWindow.add(lbl_Grade4);


        panel_MaterialsWindow = new JPanel();
        panel_MaterialsWindow.setBackground(Color.WHITE);
        panel_MaterialsWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_MaterialsWindow);
        panel_MaterialsWindow.setLayout(null);

        JLabel lbl_Materials = new JLabel("Learning Materials");
        lbl_Materials.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_Materials.setBounds(10, 11, 248, 55);
        panel_MaterialsWindow.add(lbl_Materials);

        panel_leaveFormWindow = new JPanel();
        panel_leaveFormWindow.setBackground(Color.WHITE);
        panel_leaveFormWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_leaveFormWindow);
        panel_leaveFormWindow.setLayout(null);

        JLabel lbl_Lform = new JLabel("Leave Form");
        lbl_Lform.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_Lform.setBounds(10, 11, 323, 54);
        panel_leaveFormWindow.add(lbl_Lform);

        JTextArea txta_LForm = new JTextArea();
        txta_LForm.setText("Type Here...");
        txta_LForm.setBorder(new LineBorder(new Color(0, 0, 0)));
        txta_LForm.setBounds(52, 133, 589, 244);
        panel_leaveFormWindow.add(txta_LForm);

        JPanel panel_Lsubmit = new JPanel();
        panel_Lsubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_Lsubmit.setBackground(new Color(0, 0, 139));
                lbl_LfSubmit.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_Lsubmit.setBackground(new Color(240, 240, 240));
                lbl_LfSubmit.setForeground(Color.BLACK);
            }
        });
        panel_Lsubmit.setBounds(274, 424, 121, 39);
        panel_leaveFormWindow.add(panel_Lsubmit);
        panel_Lsubmit.setLayout(null);

        lbl_LfSubmit = new JLabel("Submit");
        lbl_LfSubmit.setBounds(0, 0, 121, 39);
        panel_Lsubmit.add(lbl_LfSubmit);
        lbl_LfSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_LfSubmit.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_LfStatus = new JPanel();
        panel_LfStatus.setBounds(682, 133, 348, 380);
        panel_leaveFormWindow.add(panel_LfStatus);
        panel_LfStatus.setLayout(null);

        JLabel lbl_LfFormNo = new JLabel(" Form No:");
        lbl_LfFormNo.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfFormNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfFormNo.setBounds(63, 11, 90, 56);
        panel_LfStatus.add(lbl_LfFormNo);

        JComboBox comboBox_Lfno = new JComboBox();
        comboBox_Lfno.setBounds(195, 30, 77, 22);
        panel_LfStatus.add(comboBox_Lfno);

        JLabel lbl_LfDate = new JLabel("Date:");
        lbl_LfDate.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfDate.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfDate.setBounds(63, 156, 90, 56);
        panel_LfStatus.add(lbl_LfDate);

        JLabel lbl_LfDate1 = new JLabel(".............");
        lbl_LfDate1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfDate1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfDate1.setBounds(195, 145, 90, 56);
        panel_LfStatus.add(lbl_LfDate1);

        JLabel lbl_LfStatus = new JLabel("Status:");
        lbl_LfStatus.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfStatus.setBounds(63, 212, 90, 56);
        panel_LfStatus.add(lbl_LfStatus);

        JLabel lbl_LfStatus1 = new JLabel(".............");
        lbl_LfStatus1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfStatus1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfStatus1.setBounds(195, 212, 90, 56);
        panel_LfStatus.add(lbl_LfStatus1);

        JPanel panel_checkStatus = new JPanel();
        panel_checkStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_checkStatus.setBounds(100, 101, 121, 39);
        panel_LfStatus.add(panel_checkStatus);
        panel_checkStatus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_checkStatus.setBackground(new Color(0, 0, 139));
                lbl_checkStatus.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_checkStatus.setBackground(new Color(240, 240, 240));
                lbl_checkStatus.setForeground(Color.BLACK);
            }
        });
        panel_checkStatus.setLayout(null);

        lbl_checkStatus = new JLabel("Check Status");
        lbl_checkStatus.setBounds(0, 0, 121, 39);
        panel_checkStatus.add(lbl_checkStatus);
        lbl_checkStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_checkStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));

        panel_inquiryWindow = new JPanel();
        panel_inquiryWindow.setBackground(Color.WHITE);
        panel_inquiryWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_inquiryWindow);
        panel_inquiryWindow.setLayout(null);

        JLabel lbl_Iform = new JLabel("Inquiry");
        lbl_Iform.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_Iform.setBounds(10, 11, 323, 54);
        panel_inquiryWindow.add(lbl_Iform);

        JTextArea txta_IForm = new JTextArea();
        txta_IForm.setText("Type Here...");
        txta_IForm.setBorder(new LineBorder(new Color(0, 0, 0)));
        txta_IForm.setBounds(52, 133, 589, 244);
        panel_inquiryWindow.add(txta_IForm);

        JPanel panel_Isubmit = new JPanel();
        panel_Isubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_Isubmit.setBackground(new Color(0, 0, 139));
                lbl_Isubmit.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_Isubmit.setBackground(new Color(240, 240, 240));
                lbl_Isubmit.setForeground(Color.BLACK);
            }
        });
        panel_Isubmit.setBounds(164, 420, 121, 39);
        panel_inquiryWindow.add(panel_Isubmit);
        panel_Isubmit.setLayout(null);

        lbl_Isubmit = new JLabel("Submit");
        lbl_Isubmit.setBounds(0, 0, 121, 39);
        panel_Isubmit.add(lbl_Isubmit);
        lbl_Isubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_Isubmit.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_Response = new JPanel();
        panel_Response.setBounds(682, 21, 348, 585);
        panel_inquiryWindow.add(panel_Response);
        panel_Response.setLayout(null);

        JLabel lbl_IformNo = new JLabel(" Form No:");
        lbl_IformNo.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_IformNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_IformNo.setBounds(63, 11, 90, 56);
        panel_Response.add(lbl_IformNo);

        JComboBox comboBox_Ifno = new JComboBox();
        comboBox_Ifno.setBounds(195, 30, 77, 22);
        panel_Response.add(comboBox_Ifno);

        JLabel lbl_Response = new JLabel("Response");
        lbl_Response.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_Response.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_Response.setBounds(135, 141, 90, 19);
        panel_Response.add(lbl_Response);

        JTextArea textArea_Response = new JTextArea();
        textArea_Response.setBounds(10, 171, 328, 403);
        panel_Response.add(textArea_Response);

        JPanel panel_checkResponse = new JPanel();
        panel_checkResponse.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_checkResponse.setBounds(107, 78, 121, 39);
        panel_Response.add(panel_checkResponse);
        panel_checkResponse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_checkResponse.setBackground(new Color(0, 0, 139));
                lbl_checkResponse.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_checkResponse.setBackground(new Color(240, 240, 240));
                lbl_checkResponse.setForeground(Color.BLACK);
            }
        });
        panel_checkResponse.setLayout(null);

        lbl_checkResponse = new JLabel("Check Response");
        lbl_checkResponse.setBounds(0, 0, 121, 39);
        panel_checkResponse.add(lbl_checkResponse);
        lbl_checkResponse.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_checkResponse.setFont(new Font("Tahoma", Font.PLAIN, 15));

        panel_feeWindow = new JPanel();
        panel_feeWindow.setBackground(Color.WHITE);
        panel_feeWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_feeWindow);
        panel_feeWindow.setLayout(null);

        JLabel lbl_fee = new JLabel("Fee Payment");
        lbl_fee.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_fee.setBounds(10, 0, 228, 47);
        panel_feeWindow.add(lbl_fee);

        JPanel panel_amount = new JPanel();
        panel_amount.setBounds(117, 184, 267, 53);
        panel_feeWindow.add(panel_amount);
        panel_amount.setLayout(null);

        JLabel lbl_amount = new JLabel("Enter the amount to pay");
        lbl_amount.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_amount.setBounds(0, 0, 267, 53);
        panel_amount.add(lbl_amount);
        lbl_amount.setFont(new Font("Tahoma", Font.PLAIN, 17));

        textField_amount = new JTextField();
        textField_amount.setBounds(425, 184, 267, 53);
        panel_feeWindow.add(textField_amount);
        textField_amount.setColumns(10);

        JPanel panel_pay = new JPanel();
        panel_pay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_pay.setBackground(new Color(0, 0, 139));
                lbl_pay.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_pay.setBackground(new Color(240, 240, 240));
                lbl_pay.setForeground(Color.BLACK);
            }
        });
        panel_pay.setBounds(327, 312, 174, 41);
        panel_feeWindow.add(panel_pay);
        panel_pay.setLayout(null);

        lbl_pay = new JLabel("Pay");
        lbl_pay.setBounds(0, 0, 174, 41);
        panel_pay.add(lbl_pay);
        lbl_pay.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_pay.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_remainingFee = new JPanel();
        panel_remainingFee.setBounds(785, 68, 243, 169);
        panel_feeWindow.add(panel_remainingFee);
        panel_remainingFee.setLayout(null);

        JLabel lbl_remainingFee = new JLabel("  Remaining Fee");
        lbl_remainingFee.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbl_remainingFee.setBounds(0, 11, 233, 45);
        panel_remainingFee.add(lbl_remainingFee);

        JLabel lbl_remainingFee1 = new JLabel("0");
        lbl_remainingFee1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbl_remainingFee1.setBounds(51, 77, 192, 65);
        panel_remainingFee.add(lbl_remainingFee1);
        setVisible(true);

        panel_profileWindow.setVisible(false);
        panel_gradeWindow.setVisible(true);
        panel_MaterialsWindow.setVisible(false);
        panel_leaveFormWindow.setVisible(false);
        panel_inquiryWindow.setVisible(false);
        panel_feeWindow.setVisible(false);

        panel_profileWindow.setVisible(true);
        setVisible(true);
    }
}
