package javaquiz;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class Registration extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField regn;
    private JTextField mob;
    private JPasswordField passwordField,cpasswordField;
    private JButton btnNewButton,back;
    public static void main(String[] args) {
        new Registration();
    }

    
    public Registration() {
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(220, 80, 1014, 597);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(342, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 22));
        firstname.setBounds(214, 151, 228, 40);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lastname.setBounds(214, 235, 228, 40);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 22));
        email.setBounds(214, 320, 228, 40);
        contentPane.add(email);
        email.setColumns(10);

        regn = new JTextField();
        regn.setFont(new Font("Tahoma", Font.PLAIN, 22));
        regn.setBounds(707, 151, 228, 40);
        contentPane.add(regn);
        regn.setColumns(10);

        JLabel lblUsername = new JLabel("Register No");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 109, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Confirm Password");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(500, 329, 159, 26);
        contentPane.add(lblMobileNumber);

        cpasswordField = new JPasswordField();
        cpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        cpasswordField.setBounds(707, 320, 228, 40);
        contentPane.add(cpasswordField);
        

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField.setBounds(707, 235, 228, 40);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");     
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(200, 447, 200, 40);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(this);
        
        back = new JButton("Back");     
        back.setFont(new Font("Tahoma", Font.PLAIN, 22));
        back.setBounds(599, 447, 200, 40);
        back.setBackground(Color.lightGray);
        contentPane.add(back);
        back.addActionListener(this);
        contentPane.setBackground(Color.CYAN);
        btnNewButton.setBackground(Color.lightGray);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Back")){
            setVisible(false);
            new JavaQuiz();
        }
        else{
            Connection con = ConnectionProvider.getConnection();
            String pass=new String(passwordField.getPassword());
            String cpass=new String(cpasswordField.getPassword());
            if(!pass.equals(cpass) || pass.equals("")){
                passwordField.setText("");
                cpasswordField.setText("");
                passwordField.requestFocus();
            }
            else if(!firstname.getText().equals("") && !email.getText().equals("")){
                try{
                    int regno=Integer.parseInt(regn.getText());
                    PreparedStatement ps = con.prepareStatement("insert into public.\"UserDetails\""
                            + "(fname, lname, regno, email, upassword, score) values(?,?,?,?,?,?)");
                    ps.setString(1, firstname.getText());
                    ps.setString(2,lastname.getText());
                    ps.setInt(3, regno);
                    ps.setString(4, email.getText());
                    ps.setString(5,pass);
                    ps.setInt(6, 0);
                    ps.executeUpdate();
                    setVisible(false);
                    new JavaQuiz();
                }
                catch(NumberFormatException e){
                    btnNewButton.setBackground(Color.RED);
                    regn.setText("");
                    regn.requestFocus();
                }
                catch(Exception e){
                    btnNewButton.setEnabled(false);
                }
            }
        }
    }
}