package SchoolManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class viewmarks implements ActionListener{
    JFrame f;
    JLabel id9,id,aid,id1,aid1,id2,aid2;
    String sid, maths, science, eng;
    JButton b1,b2;
    ImageIcon icon;

    viewmarks(String e_id){
        try{
            conn con = new conn();
            String str = "select * from marks where sid = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){

                sid = rs.getString(1);
                maths = rs.getString(2);
                science = rs.getString(3);
                eng = rs.getString(4);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        f=new JFrame("Your Marks");
        f.setVisible(true);
        f.setSize(595,800);
        f.setLocation(450,200);
        f.setBackground(Color.white);
        f.setLayout(null);

        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        id9.setBackground(Color.WHITE);
        ImageIcon img=new ImageIcon("a.jpg");
        id9.setIcon(img);

        id = new JLabel("Mathematics :");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(maths);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Science :");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(science);
        aid1.setBounds(200,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);
  
        id2 = new JLabel("English : "); 
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(eng);
        aid2.setBounds(200,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);        
        
        b1=new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,270,100,30);
        b1.addActionListener(this);
        id9.add(b1);

        b2=new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,270,100,30);
        b2.addActionListener(this);
        id9.add(b2);

        f.add(id9);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            f.setVisible(false);
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
        }
    }
    public static void main(String[] args){
        new staff_data("abc");
    }

}