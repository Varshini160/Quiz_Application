package javaquiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class JavaQuiz extends JFrame implements ActionListener{
    JButton start,regi;
    JPasswordField jreg;
    JTextField jname;
    private static int re;
    public JavaQuiz(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.lightGray);
        setResizable(false);
        setLayout(null);
        
        ImageIcon w1=new ImageIcon(ClassLoader.getSystemResource("icons/java1.png"));
        JLabel welcomeImage=new JLabel(w1);
        welcomeImage.setBounds(450,5,450,470);
        add(welcomeImage);
        
        JLabel welcome=new JLabel("Welcome");
        welcome.setBounds(140,25,250,30);
        welcome.setFont(new Font("ALGERIAN", Font.BOLD, 30));
        welcome.setForeground(Color.BLACK);
        add(welcome);
        
        JLabel name=new JLabel("Enter your Register No");
        name.setBounds(110,75,190,20);
        name.setFont(new Font("ALGERIAN", Font.PLAIN, 15));
        name.setForeground(Color.BLACK);
        add(name);
        
        jname=new JTextField();
        jname.setBounds(100,105,210,25);
        jname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(jname);
        
        JLabel reg=new JLabel("Enter your Password");
        reg.setBounds(120,155,190,20);
        reg.setFont(new Font("ALGERIAN", Font.PLAIN, 15));
        reg.setForeground(Color.BLACK);
        add(reg);
        
        jreg = new JPasswordField();
        jreg.setBounds(100,185,210,25);
        jreg.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(jreg);
        
        start=new JButton("Start");
        start.setBounds(150, 250, 100, 40);
        start.setFont(new Font("SERIF", Font.BOLD, 25));
        start.setBackground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        regi=new JButton("New User");
        regi.setBounds(10,430,200,40);
        regi.setFont(new Font("SERIF", Font.BOLD, 25));
        regi.setBackground(Color.RED);
        regi.setForeground(Color.WHITE);
        regi.addActionListener(this);
        add(regi);
        
        setSize(900,520);
        setLocation(200,140);
        setTitle("Java Quiz");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Connection con = ConnectionProvider.getConnection();
        if("Start".equals(e.getActionCommand())){
            try{
                int r=Integer.parseInt(jname.getText());
                JavaQuiz.setReg(r);
                PreparedStatement ps = con.prepareStatement("SELECT upassword "+"FROM public.\"UserDetails\" WHERE regno="+r);
                ResultSet rs = ps.executeQuery();
                String p=".";
                while(rs.next())
                    p=rs.getString(1);
                if(p.equals(new String(jreg.getPassword())) && !p.equals(".")){
                    setVisible(false);
                    new Instructions();
                }
                else{
                    jreg.requestFocus();
                    jreg.setText("");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
                jname.setText("");
                jname.requestFocus();
                jreg.setText("");
            }
  
        }
        else{
            setVisible(false);
            new Registration();
        }
    }
    public static void main(String[] args) {
        new JavaQuiz();
    }
    public static void setReg(int r){
        re=r;
    }
    public static int getReg(){
        return re;
    }
}
