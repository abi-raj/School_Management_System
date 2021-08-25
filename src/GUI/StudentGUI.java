package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class StudentGUI extends JFrame {

    private JPanel panel_content;


    public static void main(String[] args) {

        new StudentGUI();

    }

    JPanel panel_profileWindow,panel_gradeWindow,panel_MaterialsWindow,panel_leaveFormWindow,panel_inquiryWindow,panel_feeWindow;
    private JLabel lbl_checkStatus,lbl_LfSubmit,lbl_Isubmit,lbl_checkResponse;
    private JLabel lbl_pay;
    private JTextField textField_amount;
    private JTable table;
    private JTextArea textArea_material;
    private JComboBox comboBox_materialno;
    private JLabel lbl_LfStatus1;
    private JLabel lbl_LfDate1;
    private JComboBox comboBox_Lfno;
    private JLabel lb_view;
    private JTextField textField_date;
    public StudentGUI() {
        sidePanel();
        profile();
        grade();
        leraningMaterials();
        leaveForm();
        inquiryForm();
        feePayment();
        panel_profileWindow.setVisible(true);
        panel_gradeWindow.setVisible(false);
        panel_MaterialsWindow.setVisible(false);
        panel_leaveFormWindow.setVisible(false);
        panel_inquiryWindow.setVisible(false);
        panel_feeWindow.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(2, 2, 1237, 665);

        setVisible(true);
    }
    private void sidePanel() {
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


        JButton btn_profileIcon = new JButton("");
        btn_profileIcon.setBackground(new Color(0, 0, 139));
        btn_profileIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(true);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        } );
        btn_profileIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/profileIcon.png"))));
        btn_profileIcon.setBounds(44, 77, 48, 51);
        btn_profileIcon.setToolTipText("Profile\r\n");
        btn_profileIcon.setFocusPainted(false);
        btn_profileIcon.setBorder(null);
        panel_side.add(btn_profileIcon);

        JButton btn_gradeIcon = new JButton("");
        btn_gradeIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(true);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        });
        btn_gradeIcon.setToolTipText("Grades");
        btn_gradeIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/gradeIcon.png")));
        btn_profileIcon.setToolTipText("Profile");
        btn_gradeIcon.setBounds(44, 162, 53, 51);
        btn_gradeIcon.setBackground(new Color(0,0,139));
        btn_gradeIcon.setBorder(null);
        btn_gradeIcon.setFocusPainted(false);
        panel_side.add(btn_gradeIcon);

        JButton btn_materialsIcon = new JButton("");
        btn_materialsIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(true);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        });
        btn_materialsIcon.setToolTipText("Learning Materials");
        btn_materialsIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/materialsIcon.png"))));
        btn_materialsIcon.setBounds(44, 251, 48, 51);
        btn_materialsIcon.setBackground(new Color(0,0,139));
        btn_materialsIcon.setBorder(null);
        btn_materialsIcon.setFocusPainted(false);
        panel_side.add(btn_materialsIcon);

        JButton btn_leaveFormIcon = new JButton("");
        btn_leaveFormIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(true);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(false);

            }
        });
        btn_leaveFormIcon.setToolTipText("Leave Form");
        btn_leaveFormIcon.setIcon(new ImageIcon(StudentGUI.class.getResource("icons/leaveFormIcon.png")));
        btn_leaveFormIcon.setBounds(44, 340, 48, 51);
        btn_leaveFormIcon.setBackground(new Color(0,0,139));
        btn_leaveFormIcon.setBorder(null);
        btn_leaveFormIcon.setFocusPainted(false);
        panel_side.add(btn_leaveFormIcon);

        JButton btn_InquiryIcon = new JButton("");
        btn_InquiryIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(true);
                panel_feeWindow.setVisible(false);

            }
        });
        btn_InquiryIcon.setToolTipText("Inquiry");
        btn_InquiryIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/inquiryIcon.png"))));
        btn_InquiryIcon.setBounds(44, 426, 48, 51);
        btn_InquiryIcon.setBackground(new Color(0,0,139));
        btn_InquiryIcon.setBorder(null);
        btn_InquiryIcon.setFocusPainted(false);
        panel_side.add(btn_InquiryIcon);

        JButton btn_feeIcon = new JButton("");
        btn_feeIcon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel_profileWindow.setVisible(false);
                panel_gradeWindow.setVisible(false);
                panel_MaterialsWindow.setVisible(false);
                panel_leaveFormWindow.setVisible(false);
                panel_inquiryWindow.setVisible(false);
                panel_feeWindow.setVisible(true);

            }
        });
        btn_feeIcon.setToolTipText("Fee Payment");
        btn_feeIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/feeIcon.png"))));
        btn_feeIcon.setBounds(44, 512, 48, 51);
        btn_feeIcon.setBackground(new Color(0,0,139));
        btn_feeIcon.setBorder(null);
        btn_feeIcon.setFocusPainted(false);
        panel_side.add(btn_feeIcon);

    }
    private void feePayment() {
        panel_feeWindow = new JPanel();
        panel_feeWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_feeWindow.setBackground(Color.WHITE);
        panel_feeWindow.setBounds(179, 0, 1034, 617);
        panel_content.add(panel_feeWindow);
        panel_feeWindow.setLayout(null);

        JPanel panel_amount = new JPanel();
        panel_amount.setBounds(117, 218, 267, 53);
        panel_feeWindow.add(panel_amount);
        panel_amount.setLayout(null);

        JLabel lbl_amount = new JLabel("Enter the amount to pay");
        lbl_amount.setBounds(0, 0, 267, 53);
        panel_amount.add(lbl_amount);
        lbl_amount.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_amount.setFont(new Font("Tahoma", Font.PLAIN, 17));

        textField_amount = new JTextField();
        textField_amount.setBounds(438, 218, 267, 53);
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
        panel_pay.setBounds(327, 341, 174, 41);
        panel_feeWindow.add(panel_pay);
        panel_pay.setLayout(null);

        lbl_pay = new JLabel("Pay");
        lbl_pay.setBounds(0, 0, 174, 41);
        panel_pay.add(lbl_pay);
        lbl_pay.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_pay.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_remainingFee = new JPanel();
        panel_remainingFee.setBounds(770, 160, 243, 169);
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

        JPanel panel_feepayment = new JPanel();
        panel_feepayment.setBorder(null);
        panel_feepayment.setBounds(10, 11, 1014, 67);
        panel_feeWindow.add(panel_feepayment);
        panel_feepayment.setLayout(null);

        JLabel lbl_fee = new JLabel("Fee Payment");
        lbl_fee.setBounds(10, 11, 144, 27);
        panel_feepayment.add(lbl_fee);
        lbl_fee.setFont(new Font("Tahoma", Font.BOLD, 22));

    }
    private void inquiryForm() {
        panel_inquiryWindow = new JPanel();
        panel_inquiryWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_inquiryWindow.setBackground(Color.WHITE);
        panel_inquiryWindow.setBounds(179, 0, 1034, 617);
        panel_content.add(panel_inquiryWindow);
        panel_inquiryWindow.setLayout(null);

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
        panel_Isubmit.setBounds(258, 419, 121, 39);
        panel_inquiryWindow.add(panel_Isubmit);
        panel_Isubmit.setLayout(null);

        lbl_Isubmit = new JLabel("Submit");
        lbl_Isubmit.setBounds(0, 0, 121, 39);
        panel_Isubmit.add(lbl_Isubmit);
        lbl_Isubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_Isubmit.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_Response = new JPanel();
        panel_Response.setBounds(676, 133, 348, 477);
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

        JPanel panel_inquiry = new JPanel();
        panel_inquiry.setBorder(null);
        panel_inquiry.setBounds(10, 11, 1014, 66);
        panel_inquiryWindow.add(panel_inquiry);
        panel_inquiry.setLayout(null);

        JLabel lbl_Iform = new JLabel("Inquiry");
        lbl_Iform.setBounds(10, 0, 323, 54);
        panel_inquiry.add(lbl_Iform);
        lbl_Iform.setFont(new Font("Tahoma", Font.BOLD, 22));

    }
    private void leaveForm() {
        panel_leaveFormWindow = new JPanel();
        panel_leaveFormWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_leaveFormWindow.setBackground(Color.WHITE);
        panel_leaveFormWindow.setBounds(178, 0, 1035, 617);
        panel_content.add(panel_leaveFormWindow);
        panel_leaveFormWindow.setLayout(null);

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
        panel_Lsubmit.setBounds(394, 424, 121, 39);
        panel_leaveFormWindow.add(panel_Lsubmit);
        panel_Lsubmit.setLayout(null);

        lbl_LfSubmit = new JLabel("Submit");
        lbl_LfSubmit.setBounds(0, 0, 111, 39);
        panel_Lsubmit.add(lbl_LfSubmit);
        lbl_LfSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_LfSubmit.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_LfStatus = new JPanel();
        panel_LfStatus.setBounds(666, 134, 348, 380);
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

        JPanel panel_lform = new JPanel();
        panel_lform.setBounds(10, 11, 1015, 66);
        panel_leaveFormWindow.add(panel_lform);
        panel_lform.setLayout(null);

        JLabel lbl_Lform = new JLabel("Leave Form");
        lbl_Lform.setBounds(10, 11, 128, 27);
        panel_lform.add(lbl_Lform);
        lbl_Lform.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel_choosedate = new JPanel();
        panel_choosedate.setLayout(null);
        panel_choosedate.setBounds(52, 424, 121, 39);
        panel_leaveFormWindow.add(panel_choosedate);

        JLabel lbl_choosedate = new JLabel("Choose Date");
        lbl_choosedate.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_choosedate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_choosedate.setBounds(0, 0, 121, 39);
        panel_choosedate.add(lbl_choosedate);

        textField_date = new JTextField();
        textField_date.setBounds(185, 424, 140, 39);
        panel_leaveFormWindow.add(textField_date);
        textField_date.setColumns(10);

    }
    private void leraningMaterials() {

        panel_MaterialsWindow = new JPanel();
        panel_MaterialsWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_MaterialsWindow.setBackground(Color.WHITE);
        panel_MaterialsWindow.setBounds(176, 0, 1037, 617);
        panel_content.add(panel_MaterialsWindow);
        panel_MaterialsWindow.setLayout(null);

        JComboBox comboBox_materialno = new JComboBox();
        comboBox_materialno.setBounds(671, 135, 68, 55);
        panel_MaterialsWindow.add(comboBox_materialno);

        JPanel panel_selectMaterial = new JPanel();
        panel_selectMaterial.setBounds(268, 135, 335, 55);
        panel_MaterialsWindow.add(panel_selectMaterial);
        panel_selectMaterial.setLayout(null);

        JLabel lbl_selectMaterial = new JLabel("Select the Material No:");
        lbl_selectMaterial.setBounds(0, 0, 335, 55);
        panel_selectMaterial.add(lbl_selectMaterial);
        lbl_selectMaterial.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_selectMaterial.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JPanel panel_material = new JPanel();
        panel_material.setBounds(153, 307, 796, 299);
        panel_MaterialsWindow.add(panel_material);
        panel_material.setLayout(null);

        JTextArea textArea_material = new JTextArea();
        textArea_material.setBounds(10, 11, 776, 277);
        panel_material.add(textArea_material);

        JPanel panel_view = new JPanel();
        panel_view.setBounds(461, 220, 144, 54);
        panel_view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_view.setBackground(new Color(0, 0, 139));
                lb_view.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel_view.setBackground(new Color(240, 240, 240));
                lb_view.setForeground(Color.BLACK);
            }
        });
        panel_MaterialsWindow.add(panel_view);
        panel_view.setLayout(null);

        lb_view = new JLabel("View");
        lb_view.setBounds(0, 0, 144, 54);
        panel_view.add(lb_view);
        lb_view.setHorizontalAlignment(SwingConstants.CENTER);
        lb_view.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JPanel panel_lmat = new JPanel();
        panel_lmat.setBorder(null);
        panel_lmat.setBounds(10, 11, 1017, 60);
        panel_MaterialsWindow.add(panel_lmat);
        panel_lmat.setLayout(null);

        JLabel lbl_Materials = new JLabel("Learning Materials");
        lbl_Materials.setBounds(10, 11, 207, 27);
        panel_lmat.add(lbl_Materials);
        lbl_Materials.setFont(new Font("Tahoma", Font.BOLD, 22));
    }
    private void grade() {
        panel_gradeWindow = new JPanel();
        panel_gradeWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_gradeWindow.setBackground(Color.WHITE);
        panel_gradeWindow.setBounds(179, 0, 1034, 617);
        panel_content.add(panel_gradeWindow);

        String column[] = {"Exam","Grades"};
        String data[][] = {{"....","......"},{".....","......."},{".......","......"},{".......","......"},{".......","......"},{".......","......"}};
        panel_gradeWindow.setLayout(null);

        JPanel panel_Table = new JPanel();
        panel_Table.setBackground(Color.WHITE);
        panel_Table.setBounds(67, 201, 874, 267);
        panel_gradeWindow.add(panel_Table);
        panel_Table.setLayout(new BoxLayout(panel_Table, BoxLayout.X_AXIS));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        panel_Table.add(scrollPane);

        table = new JTable(data,column);
        int height = table.getRowHeight();
        table.setRowHeight(height+25);
        scrollPane.setViewportView(table);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(null);
        panel_1.setBounds(10, 11, 1014, 61);
        panel_gradeWindow.add(panel_1);
        panel_1.setLayout(null);

        JLabel lbl_Grade = new JLabel("Grades");
        lbl_Grade.setBounds(10, 11, 442, 27);
        panel_1.add(lbl_Grade);
        lbl_Grade.setFont(new Font("Tahoma", Font.BOLD, 22));

    }
    private void profile() {
        panel_profileWindow = new JPanel();
        panel_profileWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_profileWindow.setBackground(Color.WHITE);
        panel_profileWindow.setBounds(178, 0, 1035, 617);
        panel_content.add(panel_profileWindow);
        panel_profileWindow.setLayout(null);

        JPanel panel_name = new JPanel();
        panel_name.setBackground(new Color(255, 222, 173));
        panel_name.setBounds(82, 115, 349, 458);
        panel_profileWindow.add(panel_name);
        panel_name.setLayout(null);

        JLabel lbl_name1 = new JLabel("Name");
        lbl_name1.setBackground(new Color(255, 182, 193));
        lbl_name1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_name1.setBounds(38, 302, 277, 47);
        panel_name.add(lbl_name1);
        lbl_name1.setFont(new Font("Tahoma", Font.BOLD, 22));

        JLabel lbl_studenticon = new JLabel("");
        lbl_studenticon.setBackground(new Color(211, 211, 211));
        lbl_studenticon.setBounds(38, 0, 266, 277);
        panel_name.add(lbl_studenticon);
        lbl_studenticon.setIcon(new ImageIcon("C:\\Users\\HARIP\\Downloads\\croupier (2).png"));

        JLabel lbl_email1 = new JLabel("19eucs001@skcet.ac.in");
        lbl_email1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_email1.setBounds(20, 360, 311, 47);
        panel_name.add(lbl_email1);
        lbl_email1.setFont(new Font("Tahoma", Font.BOLD, 17));

        JPanel panel_class = new JPanel();
        panel_class.setBackground(new Color(255, 222, 173));
        panel_class.setForeground(new Color(255, 228, 225));
        panel_class.setBounds(462, 188, 208, 111);
        panel_profileWindow.add(panel_class);
        panel_class.setLayout(null);

        JLabel lbl_class = new JLabel(" Class");
        lbl_class.setBounds(0, 0, 339, 32);
        panel_class.add(lbl_class);
        lbl_class.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lbl_class1 = new JLabel("12");
        lbl_class1.setBounds(23, 32, 185, 47);
        panel_class.add(lbl_class1);
        lbl_class1.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel_email = new JPanel();
        panel_email.setBackground(new Color(255, 222, 173));
        panel_email.setBounds(462, 325, 208, 111);
        panel_profileWindow.add(panel_email);
        panel_email.setLayout(null);

        JLabel lbl_dob = new JLabel(" Date of Birth");
        lbl_dob.setBounds(0, 0, 339, 32);
        panel_email.add(lbl_dob);
        lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lbl_dob1 = new JLabel("01/01/2001");
        lbl_dob1.setBounds(28, 39, 180, 47);
        panel_email.add(lbl_dob1);
        lbl_dob1.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel_cno = new JPanel();
        panel_cno.setBackground(new Color(255, 222, 173));
        panel_cno.setBounds(462, 462, 208, 111);
        panel_profileWindow.add(panel_cno);
        panel_cno.setLayout(null);

        JLabel lbl_cno = new JLabel(" Contact Number");
        lbl_cno.setBounds(0, 0, 339, 32);
        panel_cno.add(lbl_cno);
        lbl_cno.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lbl_cno1 = new JLabel("7708379857");
        lbl_cno1.setBounds(26, 43, 182, 47);
        panel_cno.add(lbl_cno1);
        lbl_cno1.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(10, 11, 1015, 66);
        panel_profileWindow.add(panel);
        panel.setLayout(null);

        JLabel lbl_welcome = new JLabel("Welcome Student!");
        lbl_welcome.setBounds(10, 0, 472, 63);
        panel.add(lbl_welcome);
        lbl_welcome.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 222, 173));
        panel_1.setBounds(727, 344, 289, 55);
        panel_profileWindow.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("View Events");
        lblNewLabel.setBackground(new Color(255, 228, 225));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(10, 5, 269, 39);
        panel_1.add(lblNewLabel);

    }
}
