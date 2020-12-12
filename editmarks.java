package SchoolManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class editmarks extends JFrame implements ActionListener{
 
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5;
    JTextField t,t1,t2,t3,t4,t5;
    JButton b,b1,b2;
    String Sid;
    int flag =0;

    editmarks(){
        setSize(700,650);
        setBackground(Color.white);
        setLayout(null);

        JLabel id = new JLabel("Enter Student ID to edit the marks of the student");
        id.setBounds(50,100,500,30);
        id.setFont(new Font("serif",Font.ITALIC,20));
        add(id);
        
        t1 = new JTextField();
        t1.setBounds(500,100,200,30);
        add(t1);
        
        b2 = new JButton("Enter");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720,100,100,30);
        add(b2);
        b2.addActionListener(this);

        
        id1 = new JLabel("Edit the marks : ");
        id1.setBounds(50,10,500,50);
        id1.setFont(new Font("serif",Font.ITALIC,40));
        id1.setForeground(Color.black);
        add(id1);


        id2 = new JLabel("Mathematics : ");
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        add(id2);

        t2=new JTextField();
        t2.setBounds(200,170,150,30);
        add(t2);

        id3 = new JLabel("Science : ");
        id3.setBounds(50,270,200,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        add(id3);

        t3=new JTextField();
        t3.setBounds(200,270,150,30);
        add(t3);

        id4= new JLabel("English : ");
        id4.setBounds(50,220,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        add(id4);

        t5=new JTextField();
        t5.setBounds(200,220,150,30);
        add(t5);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,400,150,40);
        
        add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,400,150,40);
        
        add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                if(flag==1)
                        JOptionPane.showMessageDialog(null,"First add the marks!!");
                else{
                int m = Integer.parseInt(t2.getText());
                int e = Integer.parseInt(t5.getText());
                int s = Integer.parseInt(t3.getText());
                if(m>100||e>100||s>100)
                    JOptionPane.showMessageDialog(null,"Marks can't be above 100!!");
                else
                {
                    conn con = new conn();
                    String str = "update marks set maths='"+t2.getText()+"',science='"+t3.getText()+"',eng="+t5.getText()+" where sid='"+t1.getText()+"'";
                    con.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"successfully updated");
                    setVisible(false);
                }} 
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            setVisible(false);
        }
        if(ae.getSource() == b2){
            try{
                conn con = new conn();
                String str = "select * from marks where sid = "+t1.getText();
                ResultSet rs = con.s.executeQuery(str);

                if(rs.next()){
                    setVisible(true);
             
                   // t1.setText(rs.getString(1));//id
                    t2.setText(rs.getString(2));//math
                    t3.setText(rs.getString(3));//science
                    t5.setText(rs.getString(4));//eng
                    flag = 0;
                    
                }
                else{
                    t2.setText("");
                    t3.setText("");
                    t5.setText("");
                    flag = 1;
                }
                
            }catch(Exception ex){}
        
        }
    }
    public static void main(String args[])
    {
        new editmarks();
    }
}