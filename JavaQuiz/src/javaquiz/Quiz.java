package javaquiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Quiz extends JFrame implements ActionListener{

String questions[][] = new String[10][5];
String answers[][] = new String[10][2];
String useranswers[][] = new String[10][1];
JLabel qno, question;
JRadioButton opt1, opt2, opt3, opt4;
ButtonGroup groupoptions;
JButton next,submit;
public static int timer = 15;
public static int ans_given = 0;
public static int count = 0;
public static int scores = 0;


Quiz() {
    setResizable(false);
    setBounds(10, 10, 1260, 670);
    //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setUndecorated(true);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 1300, 300);
    add(image);

    qno = new JLabel();
    qno.setBounds(100, 350, 50, 30);
    qno.setFont(new Font("Tahoma",Font.PLAIN, 24));
    add(qno);

    question = new JLabel("");
    question.setBounds(150, 350, 900, 30);
    question.setFont(new Font("Tahoma", Font.PLAIN, 24));
    add(question);

    questions[0][0] = "Which is used to fond and fix bugs in the Java Program.?";
	questions[0][1] = "JVM";
	questions[0][2] =  "JDB";
	questions[0][3] = "JDK";
	questions[0][4] = "JRE";

	questions[1][0] = "What is the return type of the hashcode() method in the Object class.?";
	questions[1][1] = "int";
	questions[1][2] = "object";
	questions[1][3] = "long";
	questions[1][4] = "void";

	questions[2][0] = "Which package contains the Random class.?";
	questions[2][1] = "java.util package";
	questions[2][2] = "java.lang package";
	questions[2][3] = "java.awt package";
	questions[2][4] = "java.io package";

	questions[3][0] = "compareTo() returns?";
	questions[3][1] = "true";
	questions[3][2] = "false";
	questions[3][3] = "An int value";
	questions[3][4] = "A character";

	questions[4][0] = "In which memory a string is stored, when we create a  string using new operation.?";
	questions[4][1] = "Stack";
	questions[4][2] = "String memory";
	questions[4][3] = "Random storage space";
	questions[4][4] = "Heap memory";

	questions[5][0] = "Which of the follwing is a marker interface.?";
	questions[5][1] = "Runnable interface";
	questions[5][2] =  "Remote interface";
	questions[5][3] = "Readable interface";
	questions[5][4] = "Result interface";
        
        questions[6][0] = "Number of primitive data types in Java are?";
	questions[6][1] = "7";
	questions[6][2] = "8";
	questions[6][3] = "10";
	questions[6][4] = "6";
        
        questions[7][0] = "Select the valid statement.?";
	questions[7][1] = "char[] a=new char[]";
	questions[7][2] = "char[] a=new char()";
	questions[7][3] = "char[] a=new char[5]";
	questions[7][4] = "char[] a=new char(5)";
        
        questions[8][0] = "When an array is passed to a method, what does the method receive?";
	questions[8][1] = "Copy of array";
	questions[8][2] = "Reference of array";
	questions[8][3] = "Length of array";
	questions[8][4] = "Copy of 1st element";
        
        questions[9][0] ="When is the object created with new keyword?";
	questions[9][1] = "At run time";
	questions[9][2] = "At compile time";
	questions[9][3] = "Depends on code";
	questions[9][4] = "None";
	
	answers[0][1] = "JDB";
	answers[1][1] = "int";
	answers[2][1] = "java.util package";
	answers[3][1] = "An int value";
	answers[4][1] = "Heap memory";
	answers[5][1] = "Remote interface";
        answers[6][1]="8";
        answers[7][1]="char[] a=new char[5]";
        answers[8][1]="Reference of array";
        answers[9][1]="At run time";

    opt1 = new JRadioButton("Option 1");
    opt1.setBounds(170, 420, 700, 30);
    opt1.setBackground(Color.WHITE);
    opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt1); 

    opt2 = new JRadioButton("Option 2");
    opt2.setBounds(170, 460, 700, 30);
    opt2.setBackground(Color.WHITE);
    opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt2); 

    opt3 = new JRadioButton("Option 3");
    opt3.setBounds(170, 500, 700, 30);
    opt3.setBackground(Color.WHITE);
    opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt3); 

    opt4 = new JRadioButton("Option 4");
    opt4.setBounds(170, 540, 700, 30);
    opt4.setBackground(Color.WHITE);
    opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt4); 

    groupoptions = new ButtonGroup();
    groupoptions.add(opt1);
    groupoptions.add(opt2);
    groupoptions.add(opt3);
    groupoptions.add(opt4);

    next = new JButton("Next");
    next.setBounds(1000, 450, 200, 40);
    next.setFont(new Font("Tahoma",Font.PLAIN,22));
    next.setBackground(new Color (30, 144, 255));
    next.setForeground(Color.WHITE);
    next.addActionListener(this);
    add(next);

    submit = new JButton("Submit ");
    submit.setBounds(1000, 510, 200, 40);
    submit.setFont(new Font("Tahoma",Font.PLAIN,22));
    submit.setBackground(new Color(30, 144, 255));
    submit.setForeground(Color.WHITE);
    submit.setEnabled(false);
    submit.addActionListener(this);
    add(submit );

    start(count);
    setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if("Next".equals(ae.getActionCommand())){
            repaint();
            ans_given=1;
            if(groupoptions.getSelection() == null)
                useranswers[count][0]="" ;
            else
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else{
            ans_given=1;
            if(groupoptions.getSelection() == null)
                useranswers[count][0]="" ;
            else
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            for(int i=0;i<useranswers.length;i++){
                if(useranswers[i][0].equals(answers[i][1])){
                    scores+=1;
                }
            }
            try{
                Connection con=ConnectionProvider.getConnection();
                PreparedStatement ps = con.prepareStatement("UPDATE public.\"UserDetails\" SET score="+scores+" WHERE regno="+JavaQuiz.getReg()); 
                ps.executeUpdate(); 
                new Score(scores);
                }
            catch(Exception e){      
            }
            setVisible(false);
            new Score(scores);
        }
    }

    public void paint(Graphics g){
        super.paint(g);

        String time  = "Time left: " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if(timer > 0){
            g.drawString(time, 900, 360);
        }
        else{
            g.drawString("Times up!!",900, 360);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(ans_given ==1){
            ans_given = 0;
            timer = 15;
        } 
        else if (timer < 0) {
            timer = 15;
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9){
                if(groupoptions.getSelection() == null)
                    useranswers[count][0]="" ;
                else
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                for(int i=0;i<useranswers.length;i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        scores+=1;
                    }
                }
                setVisible(false);
                try{
                    Connection con=ConnectionProvider.getConnection();
                    PreparedStatement ps = con.prepareStatement("UPDATE public.\"UserDetails\" SET score="+scores+" WHERE regno="+JavaQuiz.getReg()); 
                                     
                    ps.executeUpdate(); 
                    new Score(scores);
                }
                catch(Exception e){
                    
                }
            }
            else{
                if(groupoptions.getSelection() == null)
                    useranswers[count][0]="" ;
                else
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                count++;
                start(count);
            }
        } 
}


public void start(int count){
    qno.setText("" + ( count + 1) + ". ");
    question.setText(questions[count][0]);
    opt1.setText(questions[count][1]);
    opt1.setActionCommand(questions[count][1]);
    opt2.setText(questions[count][2]);
    opt2.setActionCommand(questions[count][2]);
    opt3.setText(questions[count][3]);
    opt3.setActionCommand(questions[count][3]);
    opt4.setText(questions[count][4]);
    opt4.setActionCommand(questions[count][4]);
    groupoptions.clearSelection();
}
public static void main(String a[]){
    new Quiz();
}
}