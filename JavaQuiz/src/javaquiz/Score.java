package javaquiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame{
    JButton leader;
    Score(int score){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(350,120,750,435);
        setResizable(false);
        setTitle("Score");
       
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        JLabel image = new JLabel(i);
        image.setBounds(0, 0, 350, 435);
        add(image);
        
        JLabel thanks = new JLabel("Thanks for attending quiz");
        thanks.setBounds(370, 50, 350, 25);
        thanks.setFont(new Font("ALGERIAN",Font.BOLD, 23));
        thanks.setForeground(Color.BLUE);
        add(thanks);

        JLabel sc = new JLabel("Score:"+score+"/10");
        sc.setBounds(440, 120, 230, 35);
        sc.setFont(new Font("ALGERIAN",Font.BOLD, 30));
        sc.setForeground(Color.BLUE);
        add(sc);
        
        leader = new JButton("Leaderboard");
        leader.setBounds(440, 200, 200, 35);
        leader.setFont(new Font("Tahoma",Font.PLAIN,22));
        leader.setBackground(Color.BLUE);
        leader.setForeground(Color.WHITE);
        leader.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                new LeaderBoard();
            }  
        }); 
        add(leader);
        
        setVisible(true);
    }
    public static void main(String a[]){
        new Score(0);
    }
}
