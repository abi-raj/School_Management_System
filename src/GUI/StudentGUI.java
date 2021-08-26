package GUI;

import database.StudentDBHelper;
import models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class StudentGUI extends JFrame {

    StudentDBHelper studentDBHelper = new StudentDBHelper();
    Student student = null;
    ArrayList<Leave> alLeave;
    ArrayList<Forum> alForum;
    ArrayList<Materials> alMaterials;
    ArrayList<Marks> alMarks;
    String[][] marksArray;
    JLabel lbl_name1;
    JLabel lbl_class1;
    JLabel lbl_email1;
    JLabel lbl_dob1;
    JLabel lbl_cno1;
    JLabel lbl_remainingFee1;
    JPanel panel_profileWindow, panel_gradeWindow, panel_MaterialsWindow, panel_leaveFormWindow, panel_inquiryWindow, panel_feeWindow;
    private JPanel panel_content;
    private JLabel lbl_checkStatus, lbl_LfSubmit, lbl_Isubmit, lbl_checkResponse;
    private JLabel lbl_pay;
    private JTextField textField_amount;
    private JTable table;
    private JTextArea textArea_material;
    private JComboBox<String> comboBox_materialno;
    private JLabel lbl_LfStatus1;
    private JLabel lbl_LfDate1;
    private JComboBox<String> comboBox_Lfno;
    private JComboBox<String> comboBox_Ifno;
    private JLabel lb_view;
    public StudentGUI(String student_id) {
        setStudent(student_id);
        sidePanel();
        profile();
        setGradesTable(); //for a reason
        grade();
        leraningMaterials();
        leaveForm();
        inquiryForm();
        feePayment();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(2, 2, 1237, 665);
        setVisible(true);
        setResizable(false);
        setInitialProfileValues();
        setFeePaymentValues();
        setLeaveFormComboBox();
        setInquiryComboBox();
        setModelComboBox();

    }

    public static void main(String[] args) {

        StudentGUI frame = new StudentGUI("19eucs001");

    }

    private void sidePanel() {
        panel_content = new JPanel();
        panel_content.setBackground(Color.WHITE);
        panel_content.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel_content);
        panel_content.setLayout(null);

        JPanel panel_side = new JPanel();
        panel_side.setBackground(new Color(29, 217, 171));
        panel_side.setBounds(20, 0, 149, 617);
        panel_content.add(panel_side);
        panel_side.setLayout(null);


        JButton btn_profileIcon = new JButton("");
        btn_profileIcon.setBackground(new Color(29, 217, 171));
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
        btn_gradeIcon.setBackground(new Color(29, 217, 171));
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
        btn_materialsIcon.setBackground(new Color(29, 217, 171));
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
        btn_leaveFormIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/leaveFormIcon.png"))));
        btn_leaveFormIcon.setBounds(44, 340, 48, 51);
        btn_leaveFormIcon.setBackground(new Color(29, 217, 171));
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
        btn_InquiryIcon.setBackground(new Color(29, 217, 171));
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
        btn_feeIcon.setBackground(new Color(29, 217, 171));
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
                panel_pay.setBackground(new Color(29, 217, 171));
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
        panel_remainingFee.setBackground(new Color(29, 217, 171));
        panel_remainingFee.setBounds(770, 160, 243, 169);
        panel_feeWindow.add(panel_remainingFee);
        panel_remainingFee.setLayout(null);

        JLabel lbl_remainingFee = new JLabel("  Remaining Fee");
        lbl_remainingFee.setForeground(Color.WHITE);
        lbl_remainingFee.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbl_remainingFee.setBounds(0, 11, 233, 45);
        panel_remainingFee.add(lbl_remainingFee);

        JLabel lbl_remainingFee1 = new JLabel("0");
        lbl_remainingFee1.setForeground(Color.WHITE);
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
        panel_pay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == panel_pay) {
                    String str = textField_amount.getText().toString().replaceAll("\\s", "");
                    if (str.length() == 0) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Enter a valid number");
                    } else {
                        int amount_entered = Integer.parseInt(str);
                        if (amount_entered < 0 || amount_entered > student.getFees() || !(studentDBHelper.payFees(student.getId(), amount_entered))) {
                            JOptionPane.showMessageDialog(StudentGUI.this, "Payment Failure");
                        } else {
                            JOptionPane.showMessageDialog(StudentGUI.this, "Payment Success");
                            setStudent(student.getId());
                            setFeePaymentValues();
                            textField_amount.setText(" ");
                        }
                    }
                }
            }
        });

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
                panel_Isubmit.setBackground(new Color(29, 217, 171));
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
        panel_Response.setBounds(676, 133, 348, 473);
        panel_inquiryWindow.add(panel_Response);
        panel_Response.setLayout(null);

        JLabel lbl_IformNo = new JLabel(" Form No:");
        lbl_IformNo.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_IformNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_IformNo.setBounds(63, 11, 90, 56);
        panel_Response.add(lbl_IformNo);

        comboBox_Ifno = new JComboBox();
        comboBox_Ifno.setBounds(195, 30, 77, 22);
        panel_Response.add(comboBox_Ifno);

        JLabel lbl_Response = new JLabel("Response");
        lbl_Response.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_Response.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_Response.setBounds(135, 141, 90, 19);
        panel_Response.add(lbl_Response);

        JTextArea textArea_Response = new JTextArea();
        textArea_Response.setBounds(10, 171, 328, 291);
        panel_Response.add(textArea_Response);

        JPanel panel_checkResponse = new JPanel();
        panel_checkResponse.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_checkResponse.setBounds(107, 78, 121, 39);
        panel_Response.add(panel_checkResponse);
        panel_checkResponse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_checkResponse.setBackground(new Color(29, 217, 171));
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
        lbl_Isubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource());
                if (txta_IForm.getText().length() < 5) {
                    JOptionPane.showMessageDialog(StudentGUI.this, "Minimum 5 characters is required");
                } else {
                    if (studentDBHelper.askQuestion(student.getId(), txta_IForm.getText())) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Inquiry posted");
                        alForum.clear();

                        setInquiryComboBox();
                    } else {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Inquiry post failed");
                    }


                }
            }
        });
        panel_checkResponse.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getSource() == panel_checkResponse) {
                    int index = Integer.parseInt(comboBox_Ifno.getItemAt(comboBox_Ifno.getSelectedIndex())) - 1;

                    if (index >= 0) {
                        Forum forum = alForum.get(index);
                        textArea_Response.setText(forum.getResponse());

                    }
                }
            }
        });

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
                panel_Lsubmit.setBackground(new Color(29, 217, 171));
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

        comboBox_Lfno = new JComboBox();
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
                panel_checkStatus.setBackground(new Color(29, 217, 171));
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

        JTextField textField_date = new JTextField();
        textField_date.setBounds(185, 424, 140, 39);
        panel_leaveFormWindow.add(textField_date);
        textField_date.setColumns(10);

        panel_Lsubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (txta_LForm.getText().length() < 5) {
                    JOptionPane.showMessageDialog(StudentGUI.this, "Minimum 5 characters is required");
                } else if (lbl_choosedate.getText().length() != 10) {
                    JOptionPane.showMessageDialog(StudentGUI.this, "Enter a valid date");
                } else if (studentDBHelper.checkLeaveAlreadyPresent(student.getId(), lbl_choosedate.getText())) {
                    JOptionPane.showMessageDialog(StudentGUI.this, "This date is already applied!");
                } else {
                    if (studentDBHelper.applyLeave(student.getId(), lbl_choosedate.getText(), txta_LForm.getText())) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Leave applied");
                        alLeave.clear();

                        setLeaveFormComboBox();
                    } else {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Leave apply failed");
                    }

                }
            }


        });
        panel_checkStatus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = Integer.parseInt(comboBox_Lfno.getItemAt(comboBox_Lfno.getSelectedIndex())) - 1;

                if (index >= 0) {
                    Leave leave = alLeave.get(index);

                    lbl_LfDate1.setText(leave.getDate());
                    if (leave.getStatus().contains("Pending")) {
                        lbl_LfStatus1.setForeground(Color.orange);
                        lbl_LfStatus1.setText(leave.getStatus());
                    }
                    if (leave.getStatus().contains("Rejected")) {
                        lbl_LfStatus1.setForeground(Color.RED);
                        lbl_LfStatus1.setText(leave.getStatus());
                    }
                    if (leave.getStatus().contains("Accepted") || leave.getStatus().contains("Approved")) {
                        lbl_LfStatus1.setForeground(Color.GREEN);
                        lbl_LfStatus1.setText(leave.getStatus());
                    }

                }
            }
        });

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
                panel_view.setBackground(new Color(29, 217, 171));
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
        panel_view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = Integer.parseInt(comboBox_Lfno.getItemAt(comboBox_Lfno.getSelectedIndex())) - 1;
                Materials material = alMaterials.get(index);
                textArea_material.setText(material.getMaterialText());
            }
        });
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

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(10, 11, 1015, 66);
        panel_profileWindow.add(panel);
        panel.setLayout(null);

        JLabel lbl_welcome = new JLabel("Welcome Student!");
        lbl_welcome.setBounds(10, 0, 270, 63);
        panel.add(lbl_welcome);
        lbl_welcome.setFont(new Font("Tahoma", Font.BOLD, 22));

        JPanel panel_viewEvent = new JPanel();
        panel_viewEvent.setBackground(new Color(29, 217, 171));
        panel_viewEvent.setBounds(713, 446, 289, 55);
        panel_profileWindow.add(panel_viewEvent);
        panel_viewEvent.setLayout(null);

        JLabel lbl_viewEvents = new JLabel("View Events");
        lbl_viewEvents.setForeground(Color.WHITE);
        lbl_viewEvents.setBackground(new Color(255, 228, 225));
        lbl_viewEvents.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_viewEvents.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbl_viewEvents.setBounds(10, 11, 269, 39);
        panel_viewEvent.add(lbl_viewEvents);

        JLabel lbl_studenticon = new JLabel("");
        lbl_studenticon.setBounds(78, 186, 266, 277);
        panel_profileWindow.add(lbl_studenticon);
        lbl_studenticon.setBackground(new Color(211, 211, 211));
        lbl_studenticon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/student.png"))));

        JLabel lbl_cno = new JLabel("Phone:");
        lbl_cno.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_cno.setBounds(354, 403, 60, 32);
        panel_profileWindow.add(lbl_cno);
        lbl_cno.setForeground(Color.BLACK);
        lbl_cno.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_cno1 = new JLabel("7708379857");
        lbl_cno1.setBounds(427, 394, 182, 47);
        panel_profileWindow.add(lbl_cno1);
        lbl_cno1.setForeground(Color.BLACK);
        lbl_cno1.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_name1 = new JLabel("Ajai Balaji");
        lbl_name1.setBounds(354, 216, 231, 47);
        panel_profileWindow.add(lbl_name1);
        lbl_name1.setForeground(Color.BLACK);
        lbl_name1.setBackground(new Color(255, 182, 193));
        lbl_name1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_name1.setFont(new Font("Tahoma", Font.BOLD, 22));

        JLabel lbl_email1 = new JLabel("19eucs001@skcet.ac.in");
        lbl_email1.setBounds(354, 265, 217, 47);
        panel_profileWindow.add(lbl_email1);
        lbl_email1.setForeground(Color.BLACK);
        lbl_email1.setBackground(new Color(216, 191, 216));
        lbl_email1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_email1.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lbl_class = new JLabel("Class:");
        lbl_class.setBounds(354, 312, 60, 32);
        panel_profileWindow.add(lbl_class);
        lbl_class.setForeground(Color.BLACK);
        lbl_class.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_class1 = new JLabel("12");
        lbl_class1.setBounds(424, 305, 185, 47);
        panel_profileWindow.add(lbl_class1);
        lbl_class1.setForeground(Color.BLACK);
        lbl_class1.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_dob = new JLabel("DOB:");
        lbl_dob.setBounds(354, 360, 60, 32);
        panel_profileWindow.add(lbl_dob);
        lbl_dob.setForeground(Color.BLACK);
        lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_dob1 = new JLabel("01/01/2001");
        lbl_dob1.setBounds(424, 351, 180, 47);
        panel_profileWindow.add(lbl_dob1);
        lbl_dob1.setForeground(Color.BLACK);
        lbl_dob1.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JLabel lbl_Logout = new JLabel("Logout");
        lbl_Logout.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lbl_Logout.setForeground(Color.RED);
        lbl_Logout.setBounds(82, 514, 81, 23);
        panel_profileWindow.add(lbl_Logout);

        JLabel lbl_eventImage = new JLabel("");
        lbl_eventImage.setBounds(714, 188, 266, 247);
        panel_profileWindow.add(lbl_eventImage);
        lbl_eventImage.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/events.jpeg"))));
//methods


    }

    void setStudent(String student_id) {
        student = studentDBHelper.viewProfile(student_id);
    }

    void setInitialProfileValues() {


        lbl_name1.setText(student.getName());
        lbl_class1.setText(student.getStd());
        lbl_email1.setText(student.getEmail());
        lbl_dob1.setText(student.getDob());
        lbl_cno1.setText(student.getPhone());
    }

    void setFeePaymentValues() {
        lbl_remainingFee1.setText(String.format("%d", student.getFees()));
    }

    void setLeaveFormComboBox() {
        comboBox_Lfno.removeAllItems();
        alLeave = studentDBHelper.getLeaveStatus(student.getId());
        for (int i = 1; i <= alLeave.size(); i++) {

            comboBox_Lfno.addItem(i + "");
        }
    }

    void setInquiryComboBox() {
        comboBox_Ifno.removeAllItems();
        alForum = studentDBHelper.getQuestionsResponse(student.getId());
        for (int i = 1; i <= alForum.size(); i++) {
            comboBox_Ifno.addItem(i + "");
        }
    }

    void setModelComboBox() {
        alMaterials = studentDBHelper.getMaterials(student.getStd());
        for (int i = 1; i <= alMaterials.size(); i++) {
            comboBox_materialno.addItem(i + "");
        }
    }

    void setGradesTable() {
        alMarks = studentDBHelper.viewGrades(student.getId());
        marksArray = new String[alMarks.size()][2];
        for (int i = 0; i < alMarks.size(); i++) {
            marksArray[i][0] = alMarks.get(i).getExam_title();
            marksArray[i][1] = alMarks.get(i).calcGrade();
        }
    }
}
