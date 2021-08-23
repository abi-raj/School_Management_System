package GUI;
import database.StudentDBHelper;
import models.Forum;
import models.Leave;
import models.Materials;
import models.Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class StudentGUI extends JFrame {

    private JPanel panel_content;
    StudentDBHelper studentDBHelper = new StudentDBHelper();
    Student student = null;
    ArrayList<Leave> alLeave;
    ArrayList<Forum> alForum;
     ArrayList<Materials> alMaterials;
    JLabel lbl_name1;
    JLabel lbl_class1;
    JLabel lbl_email1;
    JLabel lbl_dob1;
    JLabel lbl_cno1;
    JLabel lbl_remainingFee1;
    public static void main(String[] args) {

        StudentGUI frame = new StudentGUI("19eucs001");

    }

    JPanel panel_profileWindow,panel_gradeWindow,panel_MaterialsWindow,panel_leaveFormWindow,panel_inquiryWindow,panel_feeWindow;
    private JLabel lbl_checkStatus,lbl_LfSubmit,lbl_Isubmit,lbl_checkResponse;
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
        sidePanel();
        profile();
        grade();
        leraningMaterials();
        leaveForm();
        inquiryForm();
        feePayment();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(2, 2, 1237, 665);
        //setBounds(0, 0, 1350, 750);
        setVisible(true);
        setStudent(student_id);
        setInitialProfileValues();
        setFeePaymentValues();
        setLeaveFormComboBox();
        setInquiryComboBox();
        setModelComboBox();
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
        lbl_profileIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/profileIcon.png"))));
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
        lbl_gradeIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/gradeIcon.png"))));
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
        lbl_materialsIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/materialsIcon.png"))));
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
        lbl_leaveFormIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/leaveFormIcon.png"))));
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
        lbl_InquiryIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/inquiryIcon.png"))));
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
        lbl_feeIcon.setIcon(new ImageIcon(Objects.requireNonNull(StudentGUI.class.getResource("icons/feeIcon.png"))));
        lbl_feeIcon.setBounds(44, 512, 48, 51);
        panel_side.add(lbl_feeIcon);

    }
    private void feePayment() {
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

        JButton panel_pay = new JButton();
        panel_pay.addMouseListener(new MouseAdapter(){
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
        panel_pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == panel_pay) {
                    int amount_entered = Integer.parseInt(textField_amount.getText().toString());
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

         lbl_remainingFee1 = new JLabel("0");
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


    }
    private void inquiryForm() {
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
        panel_Isubmit.setBounds(258, 419, 121, 39);
        panel_inquiryWindow.add(panel_Isubmit);
        panel_Isubmit.setLayout(null);

        JButton lbl_Isubmit = new JButton("Submit");
        lbl_Isubmit.setBounds(0, 0, 121, 39);
        panel_Isubmit.add(lbl_Isubmit);
        lbl_Isubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_Isubmit.setHorizontalAlignment(SwingConstants.CENTER);

        lbl_Isubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        JPanel panel_Response = new JPanel();
        panel_Response.setBounds(682, 21, 348, 585);
        panel_inquiryWindow.add(panel_Response);
        panel_Response.setLayout(null);

        JLabel lbl_IformNo = new JLabel(" Form No:");
        lbl_IformNo.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_IformNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_IformNo.setBounds(63, 11, 90, 56);
        panel_Response.add(lbl_IformNo);

         comboBox_Ifno = new JComboBox<String>();
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

        JButton panel_checkResponse = new JButton();
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
        panel_checkResponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == panel_checkResponse) {
                    int index = Integer.parseInt(comboBox_Ifno.getItemAt(comboBox_Ifno.getSelectedIndex())) - 1;

                    if (index >= 0) {
                        Forum forum = alForum.get(index);
                        textArea_Response.setText(forum.getResponse());

                    }
                }
            }
        });
        panel_checkResponse.setLayout(null);

        lbl_checkResponse = new JLabel("Check Response");
        lbl_checkResponse.setBounds(0, 0, 121, 39);
        panel_checkResponse.add(lbl_checkResponse);
        lbl_checkResponse.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_checkResponse.setFont(new Font("Tahoma", Font.PLAIN, 15));

    }
    private void leaveForm() {
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

        JLabel choose_Date = new JLabel(" Choose Date :");
        choose_Date.setHorizontalAlignment(SwingConstants.LEFT);
        choose_Date.setFont(new Font("Tahoma", Font.BOLD, 15));
        choose_Date.setBounds(50, 300, 120, 300);
        panel_leaveFormWindow.add(choose_Date);
        JTextField choose_date1 = new JTextField();
        choose_date1.setBounds(180, 440, 100, 30);
        panel_leaveFormWindow.add(choose_date1);


        JButton submitLeave_button = new JButton();

        submitLeave_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submitLeave_button.setBackground(new Color(0, 0, 139));
                lbl_LfSubmit.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                submitLeave_button.setBackground(new Color(240, 240, 240));
                lbl_LfSubmit.setForeground(Color.BLACK);
            }
        });
        submitLeave_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitLeave_button) {
                    if (txta_LForm.getText().length() < 5) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Minimum 5 characters is required");
                    } else if (choose_date1.getText().length() != 10) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "Enter a valid date");
                    } else if (studentDBHelper.checkLeaveAlreadyPresent(student.getId(), choose_date1.getText())) {
                        JOptionPane.showMessageDialog(StudentGUI.this, "This date is already applied!");
                    } else {
                        if (studentDBHelper.applyLeave(student.getId(), choose_date1.getText(), txta_LForm.getText())) {
                            JOptionPane.showMessageDialog(StudentGUI.this, "Leave applied");
                            alLeave.clear();

                            setLeaveFormComboBox();
                        } else {
                            JOptionPane.showMessageDialog(StudentGUI.this, "Leave apply failed");
                        }

                    }
                }

            }
        });
        submitLeave_button.setBounds(400, 435, 121, 39);
        panel_leaveFormWindow.add(submitLeave_button);
        submitLeave_button.setLayout(null);
        lbl_LfSubmit = new JLabel("Submit");
        lbl_LfSubmit.setBounds(0, 0, 121, 39);
        submitLeave_button.add(lbl_LfSubmit);
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

        comboBox_Lfno = new JComboBox<String>();
        comboBox_Lfno.setBounds(195, 30, 77, 22);
        panel_LfStatus.add(comboBox_Lfno);

        JLabel lbl_LfDate = new JLabel("Date:");
        lbl_LfDate.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfDate.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfDate.setBounds(63, 156, 90, 56);
        panel_LfStatus.add(lbl_LfDate);

        lbl_LfDate1 = new JLabel(".............");
        lbl_LfDate1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfDate1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfDate1.setBounds(195, 145, 90, 56);
        panel_LfStatus.add(lbl_LfDate1);

        JLabel lbl_LfStatus = new JLabel("Status:");
        lbl_LfStatus.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfStatus.setBounds(63, 212, 90, 56);
        panel_LfStatus.add(lbl_LfStatus);

        lbl_LfStatus1 = new JLabel(".............");
        lbl_LfStatus1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_LfStatus1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_LfStatus1.setBounds(195, 212, 90, 56);
        panel_LfStatus.add(lbl_LfStatus1);

        JButton panel_checkStatus = new JButton();
        panel_checkStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_checkStatus.setBackground(new Color(240, 240, 240));
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
        panel_checkStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == panel_checkStatus) {
                    int index = Integer.parseInt(comboBox_Lfno.getItemAt(comboBox_Lfno.getSelectedIndex())) - 1;

                    if (index >= 0) {
                        Leave leave = alLeave.get(index);

                        lbl_LfDate1.setText(leave.getDate());
                        if(leave.getStatus().contains("Pending")){
                        lbl_LfStatus1.setForeground(Color.orange);
                        lbl_LfStatus1.setText(leave.getStatus());}
                        if(leave.getStatus().contains("Rejected")){
                            lbl_LfStatus1.setForeground(Color.RED);
                            lbl_LfStatus1.setText(leave.getStatus());}
                        if(leave.getStatus().contains("Accepted")){
                            lbl_LfStatus1.setForeground(Color.GREEN);
                            lbl_LfStatus1.setText(leave.getStatus());}

                    }
                }
            }
        });
        panel_checkStatus.setLayout(null);

        lbl_checkStatus = new JLabel("Check Status");
        lbl_checkStatus.setBounds(0, 0, 121, 39);
        panel_checkStatus.add(lbl_checkStatus);
        lbl_checkStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_checkStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));

    }
    private void leraningMaterials() {

        panel_MaterialsWindow = new JPanel();
        panel_MaterialsWindow.setBackground(Color.WHITE);
        panel_MaterialsWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_MaterialsWindow);
        panel_MaterialsWindow.setLayout(null);

        JLabel lbl_Materials = new JLabel("Learning Materials");
        lbl_Materials.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbl_Materials.setBounds(10, 11, 248, 55);
        panel_MaterialsWindow.add(lbl_Materials);

         comboBox_materialno = new JComboBox<>();
        comboBox_materialno.setBounds(698, 80, 120, 40);
        panel_MaterialsWindow.add(comboBox_materialno);

        JPanel panel_selectMaterial = new JPanel();
        panel_selectMaterial.setBounds(285, 75, 335, 55);
        panel_MaterialsWindow.add(panel_selectMaterial);
        panel_selectMaterial.setLayout(null);

        JLabel lbl_selectMaterial = new JLabel("Select the Material No:");
        lbl_selectMaterial.setBounds(0, 0, 335, 55);
        panel_selectMaterial.add(lbl_selectMaterial);
        lbl_selectMaterial.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_selectMaterial.setFont(new Font("Tahoma", Font.PLAIN, 17));

        JPanel panel_material = new JPanel();
        panel_material.setBounds(153, 242, 796, 364);
        panel_MaterialsWindow.add(panel_material);
        panel_material.setLayout(null);

        JTextArea textArea_material = new JTextArea();
        textArea_material.setBounds(10, 11, 776, 342);
        panel_material.add(textArea_material);

        JButton panel_view = new JButton();
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
        panel_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(comboBox_Lfno.getItemAt(comboBox_Lfno.getSelectedIndex())) - 1;
                Materials material = alMaterials.get(index);
                textArea_material.setText(material.getMaterialText());
            }
        });
        panel_view.setBounds(461, 165, 144, 54);
        panel_MaterialsWindow.add(panel_view);
        panel_view.setLayout(null);

        lb_view = new JLabel("View");
        lb_view.setBounds(0, 0, 144, 54);
        panel_view.add(lb_view);
        lb_view.setHorizontalAlignment(SwingConstants.CENTER);
        lb_view.setFont(new Font("Tahoma", Font.PLAIN, 17));
    }
    private void grade() {
        panel_gradeWindow = new JPanel();
        panel_gradeWindow.setBackground(Color.WHITE);
        panel_gradeWindow.setBounds(171, 0, 1052, 617);
        panel_content.add(panel_gradeWindow);

        JLabel lbl_Grade = new JLabel("Grades");
        lbl_Grade.setBounds(23, 25, 1052, 27);
        lbl_Grade.setFont(new Font("Tahoma", Font.BOLD, 22));

        String column[] = {"Exam","Grades"};
        String data[][] = {{"....","......"},{".....","......."},{".......","......"},{".......","......"},{".......","......"},{".......","......"}};
        panel_gradeWindow.setLayout(null);
        panel_gradeWindow.add(lbl_Grade);

        JPanel panel_Table = new JPanel();
        panel_Table.setBackground(Color.WHITE);
        panel_Table.setBounds(146, 201, 743, 213);
        panel_gradeWindow.add(panel_Table);
        panel_Table.setLayout(new BoxLayout(panel_Table, BoxLayout.X_AXIS));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        panel_Table.add(scrollPane);

        table = new JTable(data,column);
        int height = table.getRowHeight();
        table.setRowHeight(height+15);
        scrollPane.setViewportView(table);


    }
    private void profile() {
        panel_profileWindow = new JPanel();
        panel_profileWindow.setBackground(Color.WHITE);
        panel_profileWindow.setBounds(169, 0, 1054, 617);
        panel_content.add(panel_profileWindow);
        panel_profileWindow.setLayout(null);

        JPanel panel_name = new JPanel();
        panel_name.setBounds(241, 85, 339, 79);
        panel_profileWindow.add(panel_name);
        panel_name.setLayout(null);

         lbl_name1 = new JLabel("   Sample");
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

         lbl_class1 = new JLabel("   Sample");
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

         lbl_email1 = new JLabel("   Sample");
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

         lbl_dob1 = new JLabel("   Sample");
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

         lbl_cno1 = new JLabel("   Sample");
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
    void setModelComboBox(){
        alMaterials = studentDBHelper.getMaterials(student.getStd());
        for (int i = 1; i <= alMaterials.size(); i++) {
            comboBox_materialno.addItem(i+ "");
        }
    }
}