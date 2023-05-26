package javaquiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Instructions extends JFrame{
    JButton go;
    Instructions(){
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel ins=new JLabel("Instructions");
        ins.setBounds(50,25,250,30);
        ins.setFont(new Font("ALGERIAN", Font.BOLD, 30));
        ins.setForeground(Color.BLACK);
        add(ins);
        
        JLabel points=new JLabel(                
                "<html>"+"1. Questions are of Multiple Choice."
                        +"<br><br>"+"2. Each question carries one mark"+"<br><br>"
                        +"3. Click next for moving to next question "+"<br><br>"
                        +"4. Each question have 15 seconds duration"+"<br><br>"
                        +"5. You can choose only one option<br><br>"
                        +"6. Click submit when tou finished<br><br>"
                        +"</html>");
        points.setBounds(50,45,500,400);
        points.setFont(new Font("TIMES ROMAN", Font.PLAIN, 20));
        points.setForeground(Color.BLACK);
        add(points);
        
        JLabel ready=new JLabel("Ready");
        ready.setBounds(550,150,150,50);
        ready.setFont(new Font("ALGERIAN", Font.BOLD, 35));
        ready.setForeground(Color.RED);
        add(ready);
        
        go=new JButton("Go");
        go.setBounds(565, 210, 80, 40);
        go.setFont(new Font("SERIF", Font.BOLD, 25));
        go.setBackground(Color.GREEN);
        go.setForeground(Color.WHITE);
        go.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                new Quiz();
                setVisible(false);
            }  
        });  
        add(go);
        
        setSize(800,500);
        setLocation(350,100);
        setVisible(true);
    }
    public static void main(String args[]){
        new Instructions();
    }
}
