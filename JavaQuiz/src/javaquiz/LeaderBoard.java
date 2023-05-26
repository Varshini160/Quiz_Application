package javaquiz;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class LeaderBoard extends JFrame {
    JTable j;
    static int k=0;
    LeaderBoard(){
        String[][] b=new String[10][4];
        Object c[] = {"Reg no","Name","Score","Rank"};
        setTitle("LeaderBoard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try{
            Connection con=ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT regno,fname,score FROM public.\"UserDetails\" ORDER BY score desc;");
            ResultSet r=ps.executeQuery();
            while(r.next() && k<10){
                b[k][0]=Integer.toString(r.getInt(1));
                b[k][1]=r.getString(2);
                b[k][2]=r.getString(3);
                b[k][3]=Integer.toString(k+1);
                k++;
            }
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        j = new JTable(b, c);
        j.setBounds(30, 40, 200, 300);
        j.setEnabled(false);
        JScrollPane sp = new JScrollPane(j);
        add(sp);
        setLocation(250,200);
        setSize(500, 200);
        setResizable(false);
        j.setBackground(Color.CYAN);
        setVisible(true);
        
    }
    public static void main(String a[]){
        new LeaderBoard();
    }
}
